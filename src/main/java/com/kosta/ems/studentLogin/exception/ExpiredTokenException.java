package com.kosta.ems.studentLogin.exception;

public class ExpiredTokenException extends RuntimeException {
    public ExpiredTokenException() {
        super();
    }

    public ExpiredTokenException(String message) {
        super(message);
    }

    public ExpiredTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredTokenException(Throwable cause) {
        super(cause);
    }
}
