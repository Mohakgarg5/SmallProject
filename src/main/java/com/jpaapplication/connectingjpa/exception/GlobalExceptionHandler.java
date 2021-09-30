package com.jpaapplication.connectingjpa.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //Handle specific exception
    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ConfigDataResourceNotFoundException exception, WebRequest request)
    {
        CustomException customException=new CustomException(new Date(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(customException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleAPIException(ApiException exception, WebRequest request)
    {
        CustomException customException=new CustomException(new Date(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(customException, HttpStatus.NOT_FOUND);
    }
    //Handle Global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request)
    {
        CustomException customException=new CustomException(new Date(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(customException, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
