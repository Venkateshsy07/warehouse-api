package com.example.warehouse.exception;

public class BlockNotFoundException extends RuntimeException {
    public BlockNotFoundException(String message) {
        super(message);
    }
}
