package com.sudharshan.EmployeeManagementSystem.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
