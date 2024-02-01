package com.example.user.service.UserService.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    // Default constructor (no-args)
    public ApiResponse() {
    }

    // Parameterized constructor
    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Getter and Setter methods

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

