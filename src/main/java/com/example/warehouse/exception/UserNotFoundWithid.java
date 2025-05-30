package com.example.warehouse.exception;

public class UserNotFoundWithid extends RuntimeException{
    public UserNotFoundWithid(String message) {
        super(message);
    }
}
