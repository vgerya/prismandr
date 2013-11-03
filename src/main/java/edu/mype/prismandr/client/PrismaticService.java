package edu.mype.prismandr.client;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrismaticService.class);
    private static final String PRISMANDR_PROPERTIES = "prismandr.properties";
    private final Client client;

    public PrismaticService() {
        this.client = createClient();
    }

    private Client createClient() {
        ClientConfig config = new ClientConfig().register(JacksonJaxbJsonProvider.class);

        return ClientBuilder.newClient(config);
    }

    public Session login(final UserCredential userCredential) {
        WebTarget target = client.target("http://auth.getprismatic.com")
                                 .path("auth").path("login")
                                 .queryParam("api-version", "1.2")
                                 .queryParam("ignore", "true")
                                 .queryParam("whitelist_url", "http%3A%2F%2Fgetprismatic.com%2Fnews%2Fhome")
                                 .queryParam("soon_url", "http%3A%2F%2Fgetprismatic.com%2Fwelcome")
                                 .queryParam("create_url", "http%3A%2F%2Fgetprismatic.com%2Fcreateaccount")
                                 .queryParam("resetpassword_url", "http%3A%2F%2Fgetprismatic.com%2Fresetpassword");

        Response response = target.request().post(Entity
                .entity(userCredential, MediaType.APPLICATION_JSON_TYPE));

        checkResponseStatus(response);

        return Session.parseFromHeaders(response.getHeaders().get("Set-Cookie"));
    }

    private void checkResponseStatus(Response response) {
        final int statusCode = response.getStatus();
        if (statusCode == Response.Status.OK.getStatusCode())
            return;
        if (statusCode == Response.Status.FORBIDDEN.getStatusCode())
            throw new PrismaticAuthenticationException(response);
    }

    public Post fetch(Session session, NextRequest next) {
        LOGGER.debug(((next == null) ? "Initial request" : "next request: " + next) + "/n Session: " + session
                .toString());
        WebTarget target = createInitialFetchTarget();

        if (next != null) {
            target = fillNextParameters(next, target);
        }

        Invocation.Builder request = target.request();

        request = appendCookies(session, request);

        Response response = request
                .post(Entity
                        .entity(new NextToken.NextTokenBuilder().createNextToken(), MediaType.APPLICATION_JSON_TYPE));

        response.bufferEntity();
        try {
            String responseJson = response.readEntity(String.class);
            LOGGER.debug("Full response: " + responseJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Post post = response.readEntity(Post.class);
        response.close();

        return post;
    }

    private Invocation.Builder appendCookies(Session session, Invocation.Builder request) {
        for (Cookie cookie : session.getCookies()) {
            request = request.cookie(cookie);
        }
        return request;
    }

    private WebTarget fillNextParameters(NextRequest next, WebTarget target) {
        target = target.queryParam("first-article-idx", next.getQueryParams().getFirstArticleIdx())
                       .queryParam("last-article-idx", next.getQueryParams().getLastArticleIdx())
                       .queryParam("last-feed-id", next.getQueryParams().getLastFeedID())
                       .queryParam("subpage", next.getQueryParams().isSubpage());
        return target;
    }

    private WebTarget createInitialFetchTarget() {
        return client.target("http://api.getprismatic.com/")
                     .path("news/personal/personalkey")
                     .queryParam("api-version", "1.2");
    }

    public Post fetch(Session session) {
        return fetch(session, null);
    }

    public UserCredential readUserHomeCredentials() throws IOException {
        File propertiesFile = new File(System.getProperty("user.home"), PRISMANDR_PROPERTIES);
        Properties properties = new Properties();
        properties.load(new FileReader(propertiesFile));

        UserCredential credential = new UserCredential(properties.getProperty("handle"), properties
                .getProperty("password"));

        return credential;
    }


}
