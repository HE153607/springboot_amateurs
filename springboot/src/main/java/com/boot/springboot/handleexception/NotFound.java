package com.boot.springboot.handleexception;

public class NotFound extends RuntimeException{
    public NotFound(String message) {
        super(message);
    }
}
