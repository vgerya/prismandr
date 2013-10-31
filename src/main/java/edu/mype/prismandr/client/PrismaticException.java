package edu.mype.prismandr.client;

import javax.ws.rs.core.Response;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticException extends RuntimeException {
    private Response response;

    public PrismaticException() {
    }

    public PrismaticException(String message) {
        super(message);
    }

    public PrismaticException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrismaticException(Throwable cause) {
        super(cause);
    }

    public PrismaticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PrismaticException(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
