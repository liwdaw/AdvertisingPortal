package com.liwdaw.AdvertisingPortal.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    public void dataIntegrityException(ConstraintViolationException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
    }
    
}
