package com.sudharshan.EmployeeManagementSystem.service;

import com.sudharshan.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
     Employee addEmployee(Employee employee);
     List<Employee> getAllEmployees();
     List<Employee> getAllEmployeesSorted(String sortBy);
     Page<Employee> getAllEmployees(int page, int size,String sortBy);
     Employee getEmployeeById(Long id);
     Employee updateEmployee(Long id,Employee employee);
     void deleteEmployee(Long id);
}
