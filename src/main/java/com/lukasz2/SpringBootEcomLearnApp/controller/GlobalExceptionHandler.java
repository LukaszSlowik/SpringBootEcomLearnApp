package com.lukasz2.SpringBootEcomLearnApp.controller;

import com.lukasz2.SpringBootEcomLearnApp.exceptions.ProductNotFoundException;
import com.lukasz2.SpringBootEcomLearnApp.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex){
        ErrorResponse productNotFound =new ErrorResponse(LocalDateTime.now(),ex.getMessage(),"Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFound);
    }
}
