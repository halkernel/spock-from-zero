package com.spock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPayloadException extends RuntimeException{
        public InvalidPayloadException(String message) {
            super(message);
        }
}
