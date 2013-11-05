package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import static edu.mype.prismandr.client.PrismaticService.convertToJson;
import static org.fest.assertions.api.Assertions.assertThat;


/**
 * @author Vitaliy Gerya
 */
public class PrismaticServiceShould {
    private PrismaticService service;

    private static String trimSpacesAndQuotes(final String input) {
        return new String(input).replace("\"", "").replace(" ", "");
    }

    private <T> T parseFromJson(String json, Class<T> claz) throws IOException {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, false);
        provider.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        try (ByteArrayInputStream reader = new ByteArrayInputStream(json.getBytes())) {
            Object parsedObject = provider.readFrom(Object.class, claz, null, MediaType.APPLICATION_JSON_TYPE, null, reader);

            return (T) parsedObject;
        }
    }

    @Before
    public void setUp() throws Exception {
        service = new PrismaticService();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void readCredentialsFromUserHomeDirectory() throws Exception {
        UserCredential credential = service.readUserHomeCredentials();

        assertThat(credential).isNotNull();
    }

    @Test
    public void authenticateUserWithCorrectCredentials() throws Exception {
        service.login(service.readUserHomeCredentials());
    }

    @Test(expected = PrismaticAuthenticationException.class)
    public void NotAuthenticateUserWithWrongCredentials() throws Exception {
        service.login(new UserCredential("login", "some-wrong-password"));
    }

    @Test
    public void convertUserSharesCorrectly() throws Exception {
        ShareUser user = new ShareUser();
        user.setName("username");
        user.setTitle("UsEr");
        user.setDisplayKey("maxdbass");

        UserShareAction userShareAction = new UserShareAction();
        userShareAction.setScore(1.0);


        String json = convertToJson(new Article.ArticleBuilder()
                .addPrismaticShares(user, userShareAction).addPrismaticShares(
                        user, userShareAction)
                .createArticle());

        assertThat(json).isNotNull().isNotEmpty().contains("username").contains("UsEr").contains("maxdbass");
    }

    @Test
    public void readNews() throws Exception {
        Session session = service.login(service.readUserHomeCredentials());

        Post post = service.fetch(session);

        assertThat(post).isNotNull();
    }

    @Test
    public void readNextNews() throws Exception {
        Session session = service.login(service.readUserHomeCredentials());

        Post post = service.fetch(session);

        assertThat(post).as("First requested post").isNotNull();

        NextRequest next = post.getNext();

        post = service.fetch(session, next);

        assertThat(post).as("Second requested post").isNotNull();
    }

    @Test
    public void convertUserCredentialIntoJSON() throws Exception {
        UserCredential userCredential = new UserCredential("login", "password");

        assertThat(trimSpacesAndQuotes(convertToJson(userCredential)))
                .isEqualTo(trimSpacesAndQuotes("{handle:login,password:password}"));
    }

    @Test
    public void convertNextTokenRequestToJson() throws Exception {
        NextToken nextToken = new NextToken.NextTokenBuilder()
                .addSkipIds(1382970865118l, 1383031699840l, 1382971196003l, 1382730043587l, 1382994565029l, 1382908537328l, 1382806455603l)
                .addViewedData(new ViewedData.ViewedDataBuilder().setDocumentId(1382993499230l)
                                                                 .setFeedId("news415024_51037420")
                                                                 .setDwell(0l)
                                                                 .createViewedData())
                .addViewedData(new ViewedData.ViewedDataBuilder().setDocumentId(1383033721870l)
                                                                 .setFeedId("news415024_51037420")
                                                                 .setDwell(0l)
                                                                 .createViewedData())
                .addViewedData(new ViewedData.ViewedDataBuilder().setDocumentId(1382958106756l)
                                                                 .setFeedId("news415024_51037420")
                                                                 .setDwell(0l)
                                                                 .createViewedData())
                .createNextToken();

        assertThat(trimSpacesAndQuotes(convertToJson(nextToken))).isEqualTo(trimSpacesAndQuotes(
                "{\"skip-ids\":[1382970865118,1383031699840,1382971196003,1382730043587,1382994565029,1382908537328,1382806455603],\"viewed-data\":[{\"doc-id\":1382993499230,\"feed-id\":\"news415024_51037420\",\"dwell\":0},{\"doc-id\":1383033721870,\"feed-id\":\"news415024_51037420\",\"dwell\":0},{\"doc-id\":1382958106756,\"feed-id\":\"news415024_51037420\",\"dwell\":0}]}"));
    }

    @Test
    public void marshallURLAsString() throws Exception {
        URLContainer urlContainer = new URLContainer("http://www.faultseed.com/simple-string", new URL("http://www.faultseed.com/rowURL"));
        String json = convertToJson(urlContainer);

        assertThat(json).contains("http://www.faultseed.com/simple-string").contains("http://www.faultseed.com/rowURL");
    }

    @Test
    public void unmarshallURLsToObject() throws Exception {
        final String json = "{\"string-url\":\"http://www.faultseed.com/simple-string\",\"url\":\"http://www.faultseed.com/rowURL\"}";
        URLContainer urlContainer = parseFromJson(json, URLContainer.class);

        assertThat(urlContainer)
                .isEqualsToByComparingFields(new URLContainer("http://www.faultseed.com/simple-string", new URL("http://www.faultseed.com/rowURL")));
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class URLContainer {
        @XmlElement(name = "string-url")
        private String stringURL;
        @XmlElement(name = "url")
        private URL url;

        public URLContainer() {
        }

        public URLContainer(String stringURL, URL url) {
            this.stringURL = stringURL;
            this.url = url;
        }

        public String getStringURL() {
            return stringURL;
        }

        public void setStringURL(String stringURL) {
            this.stringURL = stringURL;
        }

        public URL getUrl() {
            return url;
        }

        public void setUrl(URL url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("stringURL", stringURL)
                    .append("url", url)
                    .toString();
        }
    }


}
