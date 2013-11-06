package edu.mype.prismandr.client;

import javax.ws.rs.core.Response;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticException extends RuntimeException {
    private Response response;

    public PrismaticException() {
    }

    public PrismaticException(final String message) {
        super(message);
    }

    public PrismaticException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PrismaticException(final Throwable cause) {
        super(cause);
    }

    public PrismaticException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PrismaticException(final Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
