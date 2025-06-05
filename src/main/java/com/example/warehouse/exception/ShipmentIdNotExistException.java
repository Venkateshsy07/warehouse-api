package com.example.warehouse.exception;

public class ShipmentIdNotExistException extends RuntimeException {
    public ShipmentIdNotExistException(String message) {
        super(message);
    }
}
