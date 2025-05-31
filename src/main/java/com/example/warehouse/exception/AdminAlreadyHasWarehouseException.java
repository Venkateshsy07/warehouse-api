package com.example.warehouse.exception;

public class AdminAlreadyHasWarehouseException extends RuntimeException {
    public AdminAlreadyHasWarehouseException(String message) {
        super(message);
    }
}
