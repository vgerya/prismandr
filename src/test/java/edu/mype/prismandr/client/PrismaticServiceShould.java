package edu.mype.prismandr.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * @author Vitaliy Gerya
 */
public class PrismaticServiceShould {
    private PrismaticService service;

    @Before
    public void setUp() throws Exception {
        service = new PrismaticService();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void authenticateUserWithCorrectCredentials() throws Exception {
        service.login(new UserCredential("Loord", "lourdes"));
    }

    @Test(expected = PrismaticAuthenticationException.class)
    public void NotAuthenticateUserWithWrongCredentials() throws Exception {
        service.login(new UserCredential("Loord", "some-wrong-password"));
    }

    @Test
    public void readNews() throws Exception {
        List<Post> posts = service.fetch();
    }


}
