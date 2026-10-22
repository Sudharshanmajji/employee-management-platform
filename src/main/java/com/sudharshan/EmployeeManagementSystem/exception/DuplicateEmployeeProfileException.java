package com.sudharshan.EmployeeManagementSystem.exception;

public class DuplicateEmployeeProfileException extends  RuntimeException{
    public DuplicateEmployeeProfileException(String message) {
        super(message);
    }
}
