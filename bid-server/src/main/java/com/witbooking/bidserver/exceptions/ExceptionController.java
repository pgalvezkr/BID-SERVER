package com.witbooking.bidserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler (ObjectNotFoundException.class)
    public ResponseEntity<Object> handlerObjectNotFoundException(ObjectNotFoundException exception){
        BidServerExceptionResponse response = new BidServerExceptionResponse(exception.getCode(), exception.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
