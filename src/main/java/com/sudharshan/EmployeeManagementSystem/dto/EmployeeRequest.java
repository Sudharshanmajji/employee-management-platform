package com.sudharshan.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

@Data
public class EmployeeRequest {
    @NotBlank(message ="The name shouldn't be blank")
    private String name;
    @Email
    @NotBlank(message = "The email is required")
    private String email;
    @NotBlank(message = "Department is required")
    private String department;
    @Positive(message = "Salary should be positive")
    @NotNull
    private Double salary;


}
