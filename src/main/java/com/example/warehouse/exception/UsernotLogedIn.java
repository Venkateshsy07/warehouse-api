package com.example.warehouse.exception;

public class UsernotLogedIn extends RuntimeException{
    public UsernotLogedIn(String message) {
        super(message);
    }
}
