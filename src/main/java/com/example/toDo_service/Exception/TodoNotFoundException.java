package com.example.toDo_service.Exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {}

    public TodoNotFoundException(String message) {
        super(message);
    }
}
