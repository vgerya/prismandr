package edu.mype.prismandr.client;

import javax.ws.rs.core.Response;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticAuthenticationException extends PrismaticException {
    public PrismaticAuthenticationException() {
    }

    public PrismaticAuthenticationException(final String message) {
        super(message);
    }

    public PrismaticAuthenticationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PrismaticAuthenticationException(final Throwable cause) {
        super(cause);
    }

    public PrismaticAuthenticationException(final String message, final Throwable cause,
                                            final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PrismaticAuthenticationException(final Response response) {
        super(response);
    }
}
