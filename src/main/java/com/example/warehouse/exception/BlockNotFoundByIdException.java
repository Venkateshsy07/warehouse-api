package com.example.warehouse.exception;

public class BlockNotFoundByIdException extends RuntimeException {
    public BlockNotFoundByIdException(String message) {
        super(message);
    }
}
