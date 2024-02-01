package com.example.user.service.UserService.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.user.service.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
     //it handle all the exception related project as like give info which throwing exception and all
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();

        // Create ApiResponse instance using the constructor
        ApiResponse response = new ApiResponse(message, true, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
