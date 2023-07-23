package com.example.shopingverse.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){

        super(message);
    }
}
