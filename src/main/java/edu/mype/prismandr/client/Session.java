package edu.mype.prismandr.client;

import javax.ws.rs.core.Cookie;
import java.util.*;

/**
 * @author Vitaliy Gerya
 */
public class Session {
    private final static Session EMPTY_SESSION = new Session();
    private final Map<SessionToken, Map<String, String>> cookieValues = new HashMap<SessionToken, Map<String, String>>();
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
            Map<String, String> keyValues = extractKeyValues(rowHeader);
            SessionToken token = findSessionToken(keyValues);

            session.cookieValues.put(token, keyValues);
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

    private static SessionToken findSessionToken(Map<String, String> rowHeader) {
        for (SessionToken token : SessionToken.values()) {
            if (rowHeader.keySet().contains(token.name)) {
                return token;
            }
        }

        throw new PrismaticException("New session token found=" + rowHeader);
    }

    public Map<String, String> getTokenMap(SessionToken token) {
        return cookieValues.get(token);
    }

    public String getMainTokenValue(SessionToken token) {
        return cookieValues.get(token).get(token.getName());
    }

    public Collection<Cookie> getCookies() {
        Collection<Cookie> cookies = new HashSet<>();
        for (SessionToken token : SessionToken.values()) {
            cookies.add(new Cookie(token.getName(), getMainTokenValue(token)));
        }

        return cookies;
    }


    public static enum SessionToken {
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
