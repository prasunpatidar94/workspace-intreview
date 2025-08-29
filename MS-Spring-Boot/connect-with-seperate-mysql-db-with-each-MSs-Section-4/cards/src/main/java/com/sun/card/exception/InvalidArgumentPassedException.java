package com.sun.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentPassedException extends RuntimeException {
    public InvalidArgumentPassedException(String resource, String fieldName, String fieldValue) {
        super(String.format("Invalid %s passed to get %s details : %s", fieldName,resource,fieldValue));
    }
}
