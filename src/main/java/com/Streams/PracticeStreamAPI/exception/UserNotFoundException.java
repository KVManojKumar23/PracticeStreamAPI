package com.Streams.PracticeStreamAPI.exception;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

}
