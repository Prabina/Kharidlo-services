package com.kharidlo.service.authentication.exception;

public class LoginFailureException extends Exception {
    private String reason;
    public LoginFailureException(String message, String reason) {
        super(message);
        this.reason = reason;
    }
    public LoginFailureException(){}
}
