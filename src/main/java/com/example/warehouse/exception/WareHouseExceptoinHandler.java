package com.example.warehouse.exception;

import com.example.warehouse.utility.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WareHouseExceptoinHandler{
    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleIllegalOperation(UnSupportedUserRoleException e){
        ErrorStructure errorResponse = new ErrorStructure(HttpStatus.NOT_FOUND.value(),e.getMessage());
        return new ResponseEntity<ErrorStructure>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserNotFound(WareHouseNotFindByIdException e){
        ErrorStructure errorResponse = new ErrorStructure(HttpStatus.NOT_FOUND.value(),e.getMessage());
        return new ResponseEntity<ErrorStructure>(errorResponse,HttpStatus.NOT_FOUND);
    }
}


