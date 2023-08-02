package com.gabriel.rest.webservices.restfulwebservices.exceptions.ValidationError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationError {

    private final String message;
    private final String field;
}
