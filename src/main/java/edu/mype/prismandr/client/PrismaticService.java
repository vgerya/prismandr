package edu.mype.prismandr.client;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticService {
    private final Client client;

    public PrismaticService() {
        this.client = createClient();
    }

    private Client createClient() {
        ClientConfig config = new ClientConfig().register(JacksonJaxbJsonProvider.class);

        return ClientBuilder.newClient(config);
    }

    public void login(final UserCredential userCredential) {
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

        System.out.println(response.getHeaders());

        checkResponseStatus(response);

//        MultivaluedMap<String, Object> headers = post.getHeaders();
//        List<Object> objects = headers.get("Set-Cookie");
//        System.out.println(objects);
    }

    private void checkResponseStatus(Response response) {
        final int statusCode = response.getStatus();
        if (statusCode == Response.Status.OK.getStatusCode())
            return;
        if (statusCode == Response.Status.FORBIDDEN.getStatusCode())
            throw new PrismaticAuthenticationException(response);
    }

    public List<Post> fetch() {
        WebTarget target = client.target("http://auth.getprismatic.com")
                                 .path("auth").path("login")
                                 .queryParam("api-version", "1.2")
                                 .queryParam("ignore", "true")
                                 .queryParam("whitelist_url", "http%3A%2F%2Fgetprismatic.com%2Fnews%2Fhome")
                                 .queryParam("soon_url", "http%3A%2F%2Fgetprismatic.com%2Fwelcome")
                                 .queryParam("create_url", "http%3A%2F%2Fgetprismatic.com%2Fcreateaccount")
                                 .queryParam("resetpassword_url", "http%3A%2F%2Fgetprismatic.com%2Fresetpassword");

        Response response = target.request().post(Entity
                .entity(new UserCredential("Loord", "lourdes"), MediaType.APPLICATION_JSON_TYPE));

        WebTarget target2 = client.target("http://api.getprismatic.com/")
                                 .path("news/personal/personalkey")
                                 .queryParam("api-version", "1.2")
                                 .queryParam("first-article-idx", "8")
                                 .queryParam("last-article-idx", "13")
                                 .queryParam("last-feed-id", "news415024_51037420")
                                 .queryParam("subpage", "true");

        Invocation.Builder request = target.request();
        MultivaluedMap<String,Object> headers = response.getHeaders();
        List<Object> objects = headers.get("Set-Cookie");
        Session session = Session.parseFromHeaders(objects);

        Response response2 = request.post(Entity.entity(new NextToken(), MediaType.APPLICATION_JSON_TYPE));



        /*p_public=chl0ek84b9vv6rh2g3e9mtt18s04lohl; preview-prismatic=true; __utma=205000015.301489109.1363956109.1380198284.1383041682.59; __utmb=205000015.2.10.1383041682; __utmc=205000015; __utmz=205000015.1383041682.59.5.utmcsr=preview.getprismatic.com|utmccn=(referral)|utmcmd=referral|utmcct=/profile/Loord; prismatic-whitelist=43; prismatic=150597__1383042270070__b0j0VLezJV25O2i4NlrTkfHebxl30YgvJf%2F6iNMnqU%3D; _ga=GA1.2.301489109.1363956109; mp_394275b2612ced0084e3021d87396ea8_mixpanel=%7B%22distinct_id%22%3A%20%22150597%22%2C%22%24initial_referrer%22%3A%20%22http%3A%2F%2Fgetprismatic.com%2Fnews%2Fhome%22%2C%22%24initial_referring_domain%22%3A%20%22getprismatic.com%22%2C%22mp_name_tag%22%3A%20%22Loord%22%2C%22__mps%22%3A%20%7B%7D%2C%22__mpso%22%3A%20%7B%7D%2C%22__mpa%22%3A%20%7B%7D%2C%22__mpap%22%3A%20%5B%5D%7D; _ps_api=150597__89g7zszfyexrmb1zkcru57zyntg5369c; AWSELB=1509F1AD0A09EB6CF04ACC3B93041502497BC0E394F75F7C3A2D52F0033300870BB360D1FCA398F60F2FB780020434B0646242C0B0D3613D1CA44013350E641F18D4C04C8DEC0BC4836EDD952AB12A8711C04FE78C*/

        return null;
    }
}
