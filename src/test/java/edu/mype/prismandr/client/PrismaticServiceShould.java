package edu.mype.prismandr.client;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * @author Vitaliy Gerya
 */
public class PrismaticServiceShould {
    private PrismaticService service;

    private static String trimSpacesAndQuotes(final String input) {
        return new String(input).replace("\"", "").replace(" ", "");
    }

    private static String convertToJson(Object value) throws IOException {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, false);
        provider.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            provider.writeTo(value, value
                    .getClass(), null, null, MediaType.APPLICATION_JSON_TYPE, null, baos);
            return new String(baos.toByteArray());
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
    public void readNews() throws Exception {
        Session session = service.login(service.readUserHomeCredentials());

        Post posts = service.fetch(session);
    }

    @Test
    public void convertUserCredentialIntoJSON() throws Exception {
        UserCredential userCredential = new UserCredential("login", "password");

        assertThat(trimSpacesAndQuotes(convertToJson(userCredential)))
                .isEqualTo(trimSpacesAndQuotes("{handle:login,password:password}"));
    }

    @Test
    public void convertNextTokenRequestToJson() throws Exception {
        NextToken nextToken = new NextTokenBuilder()
                .addSkipIds(1382970865118l, 1383031699840l, 1382971196003l, 1382730043587l, 1382994565029l, 1382908537328l, 1382806455603l)
                .addViewedData(new ViewedDataBuilder().setDocumentId(1382993499230l)
                                                      .setFeedId("news415024_51037420")
                                                      .setDwell(0l)
                                                      .createViewedData())
                .addViewedData(new ViewedDataBuilder().setDocumentId(1383033721870l)
                                                      .setFeedId("news415024_51037420")
                                                      .setDwell(0l)
                                                      .createViewedData())
                .addViewedData(new ViewedDataBuilder().setDocumentId(1382958106756l)
                                                      .setFeedId("news415024_51037420")
                                                      .setDwell(0l)
                                                      .createViewedData())
                .createNextToken();

        assertThat(trimSpacesAndQuotes(convertToJson(nextToken))).isEqualTo(trimSpacesAndQuotes(
                "{\"skip-ids\":[1382970865118,1383031699840,1382971196003,1382730043587,1382994565029,1382908537328,1382806455603],\"viewed-data\":[{\"doc-id\":1382993499230,\"feed-id\":\"news415024_51037420\",\"dwell\":0},{\"doc-id\":1383033721870,\"feed-id\":\"news415024_51037420\",\"dwell\":0},{\"doc-id\":1382958106756,\"feed-id\":\"news415024_51037420\",\"dwell\":0}]}"));
    }

}
