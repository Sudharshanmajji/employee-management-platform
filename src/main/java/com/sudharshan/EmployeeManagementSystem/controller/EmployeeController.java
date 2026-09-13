package com.sudharshan.EmployeeManagementSystem.controller;

import com.sudharshan.EmployeeManagementSystem.entity.Employee;
import com.sudharshan.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
     private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Long id,@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }
}
