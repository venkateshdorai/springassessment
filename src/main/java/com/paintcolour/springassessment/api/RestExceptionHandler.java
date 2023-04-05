package com.paintcolour.springassessment.api;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ ColorNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Color not found", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
	
	
	@ExceptionHandler({ InvalidParametersException.class })
    protected ResponseEntity<Object> handleNotValid(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "One or More color values are not valid", 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	 
	
	@ExceptionHandler({ ColorNameMismatchException.class, 
	      ConstraintViolationException.class, 
	      DataIntegrityViolationException.class })
	    public ResponseEntity<Object> handleBadRequest(
	      Exception ex, WebRequest request) {
	        return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
	          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	    }
}

