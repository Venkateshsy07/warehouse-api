package com.example.warehouse.exception;

public class InvalidUserRole extends RuntimeException {
    public InvalidUserRole(String message) {
        super(message);
    }
}
