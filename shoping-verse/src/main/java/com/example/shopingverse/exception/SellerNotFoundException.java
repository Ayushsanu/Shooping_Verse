package com.example.shopingverse.exception;

public class SellerNotFoundException extends RuntimeException{
    public SellerNotFoundException(String message){
        super(message);
    }
}
