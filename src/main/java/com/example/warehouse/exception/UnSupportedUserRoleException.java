package com.example.warehouse.exception;

public class UnSupportedUserRoleException extends RuntimeException {
    public UnSupportedUserRoleException(String message) {
        super(message);
    }
}
