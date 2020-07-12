package com.spock.handler;

import com.spock.exceptions.EntityNotFoundException;
import com.spock.exceptions.InvalidPayloadException;
import com.spock.handler.model.GenericErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> handle(EntityNotFoundException e) {
        GenericErrorResponse genericErrorResponse =
                new GenericErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.name(),
                        e.getMessage());
        return new ResponseEntity<>(genericErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPayloadException.class)
    public ResponseEntity<GenericErrorResponse> handle(InvalidPayloadException e) {
        GenericErrorResponse genericErrorResponse =
                new GenericErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        e.getMessage());
        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
