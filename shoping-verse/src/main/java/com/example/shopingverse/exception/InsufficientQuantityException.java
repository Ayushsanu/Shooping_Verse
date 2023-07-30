package com.example.shopingverse.exception;

public class InsufficientQuantityException extends RuntimeException{
    public InsufficientQuantityException(String message){
        super(message);
    }
}
