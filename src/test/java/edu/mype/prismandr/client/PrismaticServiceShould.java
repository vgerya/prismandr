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

        Post post = service.fetch(session);

        assertThat(trimSpacesAndQuotes(convertToJson(post))).isEqualTo(trimSpacesAndQuotes("{\"interest\": {    \"des\": \"Stories from your interests\",    \"key\": \"personalkey\",    \"title\": \"Home\",    \"type\": \"personal\"}, \"next\": {    \"remaining-count\": 495,    \"query-params\": {        \"subpage\": \"true\",        \"last-feed-id\": \"news139618_10558514\",        \"first-article-idx\": 0,        \"last-article-idx\": 5    }}, \"removed\": {    \"remaining-count\": 265}, \"related-interests\": {    \"interests\": {        \"url\": \"/user/interests/interests?api-version=1.0\",        \"title\": \"Interests\",        \"count\": 132    },    \"following\": {        \"url\": \"/user/interests/following?api-version=1.0\",        \"title\": \"Following\",        \"count\": 18    }}, \"id\": \"news139618_10558514\", \"start\": 0, \"docs\": [    {        \"text\": \"Some people know what they want to do from an early age and focus on it relentlessly...\",        \"date\": 1383101617000,        \"prismatic-activity\": {            \"save\": 11,            \"comment\": 1,            \"remove\": 13,            \"share\": 5,            \"email\": 4,            \"bookmark\": 10,            \"click\": 291        },        \"first-degree-connections\": {            \"prismatic-actions\": [],            \"external-actions\": [],            \"interests\": [                {                    \"type\": \"topic\",                    \"key\": \"Innovation\",                    \"title\": \"Innovation\"                }            ]        },        \"images\": [            {                \"in-div\": true,                \"orig-size\": {                    \"height\": \"494\",                    \"width\": \"400\"                },                \"size\": {                    \"width\": 400,                    \"height\": 494                },                \"url\": \"http://162.13.24.191/magazine/wp-content/uploads/2013/10/Marissa-Mayer.jpg\"            },            {                \"url\": \"http://static1.businessinsider.com/image/4c8f92217f8b9aa627a70000-1200/mark-cuban-was-a-bartender-in-dallas.jpg\",                \"size\": {                    \"width\": 400,                    \"height\": 300                },                \"orig-size\": {                    \"height\": \"300\",                    \"width\": \"400\"                },                \"prob\": 0.3471306395903888,                \"in-div\": true            }        ],        \"author\": {            \"url\": null,            \"name\": \"TeamInc42\"        },        \"commerce\": null,        \"title\": \"What Some Extremely Successful People Were Doing At 25\",        \"url\": \"http://inc42.com/magazine/entrepreneurship/what-some-extremely-successful-people-were-doing-at-25/\",        \"feed\": {            \"type\": \"feed\",            \"key\": \"http://inc42.com/magazine/feed/\",            \"title\": \"Inc42 Magazine\",            \"img\": \"http://imagecdn.getprismatic.com/pub/16/8908960517463269437.png\",            \"highres-img\": \"http://imagecdn.getprismatic.com/pub/big/8908960517463269437.png\"        },        \"prismatic-shares\": [            [                {                    \"display-key\": \"RalphyContreras\",                    \"key\": 83909,                    \"name\": \"Rafa Contreras\",                    \"title\": \"RalphyContreras\",                    \"img\": \"http://cdn.getprismatic.com/cdn/img/profile/default_avatar1.jpg\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"bookmark\", \"share\"],                    \"score\": 2.6E-9,                    \"following?\": false                }            ],            [                {                    \"display-key\": \"anthony1\",                    \"key\": 160466,                    \"name\": \"Anthony Hutcheson\",                    \"title\": \"anthony1\",                    \"img\": \"http://graph.facebook.com/anthony.hutcheson.71/picture?type=large\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"share\", \"bookmark\"],                    \"score\": 2.6E-9,                    \"following?\": false                }            ]        ],        \"comments\": [            {                \"text\": \"working hard ..\",                \"date\": 1383203661523,                \"text-entities\": {                    \"user-mentions\": []                },                \"action-counts\": {},                \"type\": \"comment\",                \"parent-comment-id\": null,                \"user\": {                    \"display-key\": \"akulbansal5\",                    \"key\": 11873,                    \"name\": \"Akul Bansal\",                    \"title\": \"akulbansal5\",                    \"img\": \"http://s3.amazonaws.com/prismatic-profiles/primary-image-433041411.jpeg\",                    \"type\": \"activity\"                },                \"user-share-ids\": {},                \"id\": 22131258586100,                \"actions\": {                    \"items\": [],                    \"remaining-count\": 0                }            }        ],        \"user-share-ids\": {},        \"id\": 1383134573531,        \"home-interests\": [            {                \"type\": \"topic\",                \"key\": \"Innovation\"            }        ],        \"num-shares\": 351,        \"topics\": [            {                \"type\": \"topic\",                \"key\": \"Innovation\",                \"title\": \"Innovation\"            },            {                \"type\": \"topic\",                \"key\": \"Entrepreneurship\",                \"title\": \"Entrepreneurship\"            }        ]    },    {        \"text\": \"Disclaimer(s): ZeroTurnaround supports eliminating redeploys in Scala development with free JRebel licenses (more info)...\",        \"date\": 1383169372923,        \"prismatic-activity\": {            \"save\": 9,            \"remove\": 3,            \"share\": 2,            \"bookmark\": 7,            \"click\": 38        },        \"first-degree-connections\": {            \"prismatic-actions\": [],            \"external-actions\": [],            \"interests\": [                {                    \"type\": \"topic\",                    \"key\": \"Scala (programming language)\",                    \"title\": \"Scala (programming language)\"                },                {                    \"type\": \"topic\",                    \"key\": \"Functional Programming\",                    \"title\": \"Functional Programming\"                }            ]        },        \"images\": [],        \"author\": {            \"url\": \"http://zeroturnaround.com/author/erkki/\",            \"name\": \"Erkki Lindpere\"        },        \"commerce\": null,        \"title\": \"Scala: Sink or Swim? Part 1\",        \"url\": \"http://zeroturnaround.com/rebellabs/scala-sink-or-swim-part-1/\",        \"feed\": {            \"type\": \"feed\",            \"key\": \"http://zeroturnaround.com/feed/\",            \"title\": \"zeroturnaround.com\",            \"img\": \"http://imagecdn.getprismatic.com/pub/16/192759481141073896.ico\"        },        \"prismatic-shares\": [            [                {                    \"display-key\": \"flash_us\",                    \"key\": 45074,                    \"name\": \"Ilya Dyachenko\",                    \"title\": \"flash_us\",                    \"img\": \"http://a0.twimg.com/profile_images/392679859/ava_twitter2_bigger.jpg\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"bookmark\", \"share\"],                    \"score\": 2.6E-9,                    \"following?\": false                }            ]        ],        \"comments\": [],        \"user-share-ids\": {},        \"id\": 1383169345685,        \"home-interests\": [            {                \"type\": \"raw\",                \"key\": \"ant\"            },            {                \"type\": \"topic\",                \"key\": \"Functional Programming\"            },            {                \"type\": \"topic\",                \"key\": \"Scala (programming language)\"            }        ],        \"num-shares\": 65,        \"topics\": [            {                \"type\": \"topic\",                \"key\": \"Scala (programming language)\",                \"title\": \"Scala (programming language)\"            },            {                \"type\": \"topic\",                \"key\": \"Functional Programming\",                \"title\": \"Functional Programming\"            }        ]    },    {        \"related\": {            \"type\": \"related\",            \"key\": 1383165256195        },        \"text\": \"Whether trying to conquer Mount Everest or just pick up your laundry, learning these quick facts will make it easier to be super productive -- or at least understand why you're not.\\n\\nAnd if you're the type of person who is likely procrastinate instead of reading the rest of this article, then you should at least read the first point.\\n\\n1. Simply starting a task will make it much easier to finish.\\n\\nAccording to the Zeigarnik Effect, your brain will send signals that effectively nag your conscious mind when you've started, but not finished, an objective. Bluma Zeigarnik was a Soviet psychologist who first developed the theory that humans are naturally driven to finish what they've started, due to a dissonance they feel when tasks are begun and then left incomplete.\\n\\nIn 1992, a pair of psychologists proved this theory in a study on task interruption. They saw that the feeling of uneasiness unleashed in the brain could only be quelled by completing the started task. In other words, although...\",        \"date\": 1383148262000,        \"prismatic-activity\": {            \"save\": 2,            \"email\": 1,            \"bookmark\": 3,            \"click\": 21        },        \"first-degree-connections\": {            \"prismatic-actions\": [],            \"external-actions\": [],            \"interests\": [                {                    \"type\": \"topic\",                    \"key\": \"Productivity\",                    \"title\": \"Productivity\"                }            ]        },        \"images\": [            {                \"in-div\": true,                \"orig-size\": {},                \"size\": {                    \"width\": 570,                    \"height\": 379                },                \"url\": \"http://i.huffpost.com/gen/1425523/thumbs/o-174457199-570.jpg?1\"            },            {                \"url\": \"http://i.huffpost.com/gen/1425507/thumbs/o-130902654-570.jpg?1\",                \"size\": {                    \"width\": 570,                    \"height\": 427                },                \"orig-size\": {},                \"prob\": 0.2944342438481514,                \"in-div\": true            },            {                \"url\": \"http://i.huffpost.com/gen/1425530/thumbs/o-83587751-570.jpg?1\",                \"size\": {                    \"width\": 570,                    \"height\": 427                },                \"orig-size\": {},                \"prob\": 0.2944342438481514,                \"in-div\": true            }        ],        \"author\": {            \"name\": \"todd.vanluling@huffingtonpost.com (Todd Van Luling)\",            \"url\": null        },        \"commerce\": null,        \"title\": \"Just Knowing These 8 Facts Will Make You Way More Productive\",        \"url\": \"http://www.huffingtonpost.com/2013/10/30/facts-more-productive_n_4150440.html\",        \"feed\": {            \"type\": \"feed\",            \"key\": \"http://feeds.huffingtonpost.com/FeaturedPosts\",            \"title\": \"The Blog\",            \"img\": \"http://imagecdn.getprismatic.com/pub/16/-5739277607409410978.ico\"        },        \"prismatic-shares\": [            [                {                    \"display-key\": \"chriskuti\",                    \"key\": 49313,                    \"name\": \"Chris Kuti\",                    \"title\": \"chriskuti\",                    \"img\": \"http://a0.twimg.com/profile_images/2222156260/ProfileZoom_Summer__12__bigger.jpg\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"bookmark\"],                    \"score\": 1.0E-9,                    \"following?\": false                }            ],            [                {                    \"display-key\": \"leftov3r\",                    \"key\": 171176,                    \"name\": \"David Chang\",                    \"title\": \"leftov3r\",                    \"img\": \"http://a0.twimg.com/profile_images/3187564471/59e04be66bc9c4c827ca5de6a3bd05a4_bigger.jpeg\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"bookmark\"],                    \"score\": 1.0E-9,                    \"following?\": false                }            ],            [                {                    \"display-key\": \"csbyjw\",                    \"key\": 51038,                    \"name\": \"csbyjw\",                    \"title\": \"csbyjw\",                    \"img\": \"http://cdn.getprismatic.com/cdn/img/profile/default_avatar3.jpg\",                    \"type\": \"activity\"                },                {                    \"actions\": [\"bookmark\"],                    \"score\": 1.0E-9,                    \"following?\": false                }            ]        ],        \"comments\": [],        \"user-share-ids\": {},        \"id\": 1383165256195,        \"home-interests\": [            {                \"type\": \"topic\",                \"key\": \"Productivity\"            }        ],        \"num-shares\": 156,        \"topics\": [            {                \"type\": \"topic\",                \"key\": \"Productivity\",                \"title\": \"Productivity\"            },            {                \"type\": \"topic\",                \"key\": \"Cognitive Psychology\",                \"title\": \"Cognitive Psychology\"            },            {                \"type\": \"topic\",                \"key\": \"Psychology\",                \"title\": \"Psychology\"            }        ]    }]}‰"));
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
