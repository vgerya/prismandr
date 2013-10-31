package edu.mype.prismandr.client;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author Vitaliy Gerya
 */
public class SessionShould {
    private List<Object> testHeaders = Arrays
            .<Object>asList("AWSELB=936953DB108D68DEB20CB5D06387A190C1BFA7DCE57BD83126FC974AC4472DA9FD4F4FAC3B545CECB75FE926D07CA0EFDF5ABF926A62A72CBAE4D5913F403B68B4587BF681;PATH=/;MAX-AGE=900",
                    "prismatic=150597__1383152871518__rJ8WrYOvJK6GDFCzHdvhvOe3uR0s9EkRzFo9V2QdU0%3D;Expires=Thu, 30-Oct-2014 17:07:51 GMT;Path=/;Domain=.getprismatic.com",
                    "prismatic-whitelist=43;Expires=Thu, 30-Oct-2014 17:07:51 GMT;Domain=.getprismatic.com;Path=/",
                    "_ps_www=10ugf1r61nxbb5qcqunl__1ged1su23u7ot8dwkj24s1xvtojn06oi;Expires=Wed, 30-Oct-2013 17:22:51 GMT;Path=/"
            );

    @Test
    public void parseMainValues() throws Exception {

        Session session = Session.parseFromHeaders(testHeaders);
        assertThat(session.getMainTokenValue(Session.SessionToken.AWSELB))
                .isEqualTo("936953DB108D68DEB20CB5D06387A190C1BFA7DCE57BD83126FC974AC4472DA9FD4F4FAC3B545CECB75FE926D07CA0EFDF5ABF926A62A72CBAE4D5913F403B68B4587BF681");

        assertThat(session.getMainTokenValue(Session.SessionToken.PRISMATIC))
                .isEqualTo("150597__1383152871518__rJ8WrYOvJK6GDFCzHdvhvOe3uR0s9EkRzFo9V2QdU0%3D");

        assertThat(session.getMainTokenValue(Session.SessionToken.PRISMATIC_WHITELIST))
                .isEqualTo("43");
    }

}
