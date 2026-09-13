package com.sudharshan.EmployeeManagementSystem.service;

import com.sudharshan.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
     Employee addEmployee(Employee employee);
     List<Employee> getAllEmployees();
     Employee getEmployeeById(Long id);
     Employee updateEmployee(Long id,Employee employee);
     void deleteEmployee(Long id);
}
