package com.example.testapi.exception;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}