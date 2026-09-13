package com.sudharshan.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "employees")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="employee_name",nullable = false)
    private String name;
    private String email;
    private String department;
    private Double salary;
}
