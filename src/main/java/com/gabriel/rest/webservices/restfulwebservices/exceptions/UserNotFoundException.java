package com.gabriel.rest.webservices.restfulwebservices.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String message){
        super(message);
    }
}
