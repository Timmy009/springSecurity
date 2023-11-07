package com.example.demotwo.security.exceptions;

public class AuthenticationNotSupportedException extends  RuntimeException{
    public AuthenticationNotSupportedException(String message) {
        super(message);
    }

}
