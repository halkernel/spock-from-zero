package com.spock.exceptions;

public class InvalidPayloadException extends RuntimeException{

        public InvalidPayloadException(String message) {
            super(message);
        }
}
