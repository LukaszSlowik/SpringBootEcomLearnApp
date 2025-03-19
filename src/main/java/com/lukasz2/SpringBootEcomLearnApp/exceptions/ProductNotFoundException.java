package com.lukasz2.SpringBootEcomLearnApp.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
