package edu.mype.prismandr.client;

import javax.ws.rs.core.Response;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticAuthenticationException extends PrismaticException {
    public PrismaticAuthenticationException() {
    }

    public PrismaticAuthenticationException(String message) {
        super(message);
    }

    public PrismaticAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrismaticAuthenticationException(Throwable cause) {
        super(cause);
    }

    public PrismaticAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PrismaticAuthenticationException(Response response) {
        super(response);
    }
}
