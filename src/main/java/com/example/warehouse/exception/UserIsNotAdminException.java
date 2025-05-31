package com.example.warehouse.exception;

public class UserIsNotAdminException extends RuntimeException {
    public UserIsNotAdminException(String message) {
        super(message); 
    }
}
