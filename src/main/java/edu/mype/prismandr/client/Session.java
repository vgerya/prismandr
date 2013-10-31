package edu.mype.prismandr.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vitaliy Gerya
 *         [0] = {java.lang.String@2195}"AWSELB=936953DB108D68DEB20CB5D06387A190C1BFA7DCE57BD83126FC974AC4472DA9FD4F4FAC3B545CECB75FE926D07CA0EFDF5ABF926A62A72CBAE4D5913F403B68B4587BF681;PATH=/;MAX-AGE=900"
 *         [1] = {java.lang.String@2196}"prismatic=150597__1383152871518__rJ8WrYOvJK6GDFCzHdvhvOe3uR0s9EkRzFo9V2QdU0%3D;Expires=Thu, 30-Oct-2014 17:07:51 GMT;Path=/;Domain=.getprismatic.com"
 *         [2] = {java.lang.String@2197}"prismatic-whitelist=43;Expires=Thu, 30-Oct-2014 17:07:51 GMT;Domain=.getprismatic.com;Path=/"
 *         [3] = {java.lang.String@2198}"_ps_www=10ugf1r61nxbb5qcqunl__1ged1su23u7ot8dwkj24s1xvtojn06oi;Expires=Wed, 30-Oct-2013 17:22:51 GMT;Path=/"
 */
public class Session {
    private final static Session EMPTY_SESSION = new Session();
    private final Map<SessionToken, String> mainValues = new HashMap<SessionToken, String>();
    private final Map<SessionToken, Map<String, String>> subValues = new HashMap<SessionToken, Map<String, String>>();
    private String awselb;

    public static Session parseFromHeaders(List<Object> objects) {
        if (objects == null || objects.isEmpty()) {
            return EMPTY_SESSION;
        }

        Session session = new Session();
        for (Object header : objects) {
            if (!(header instanceof String)) {
                throw new PrismaticException("Undefined type of header: " + header.getClass() + " value=" + header);
            }

            String rowHeader = (String) header;
            SessionToken token = findSessionToken(rowHeader);

            Map<String, String> keyValues = extractKeyValues(rowHeader);

            session.mainValues.put(token,keyValues.get(token.getName()));
            session.subValues.put(token, keyValues);
        }

        return session;
    }

    private static Map<String, String> extractKeyValues(String rowHeader) {
        final Map<String, String> result = new HashMap<>();
        String[] keyValues = rowHeader.split(";");
        for (String keyValue : keyValues) {
            String[] split = keyValue.split("=");
            result.put(split[0], split[1]);
        }

        return result;
    }

    private static SessionToken findSessionToken(String rowHeader) {
        for (SessionToken token : SessionToken.values()) {
            if (rowHeader.startsWith(token.name)) {
                return token;
            }
        }

        throw new PrismaticException("New session token found=" + rowHeader);
    }

    private static enum SessionToken {
        AWSELB("AWSELB"),
        PRISMATIC("prismatic"),
        PRISMATIC_WHITELIST("prismatic-whitelist"),
        PS_WWW("_ps_www");
        private final String name;

        private SessionToken(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }
    }
}
