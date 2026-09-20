package com.sudharshan.EmployeeManagementSystem.service;

import com.sudharshan.EmployeeManagementSystem.entity.Employee;
import com.sudharshan.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.sudharshan.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository=employeeRepository;
    }
    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    public List<Employee> getAllEmployeesSorted(String sortBy)
    {
        Sort sort=Sort.by(
                Sort.Direction.ASC,
                sortBy
        );
        return employeeRepository.findAll(sort);
    }
    @Override
    public Page<Employee> getAllEmployees(int page, int size,String sortBy) {

        Pageable pageable = PageRequest.of(page, size,Sort.by(
                Sort.Order.asc(sortBy),
                Sort.Order.asc("name")
        )
        );
        return employeeRepository.findAll(pageable);
    }
    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Id not Found with " + id)
        );
    }
    public Employee updateEmployee(Long id,Employee employee)
    {
        Employee ExistingEmployee=employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Id not Exists " +id)
        );
        ExistingEmployee.setName(employee.getName());
        ExistingEmployee.setEmail(employee.getEmail());
        ExistingEmployee.setDepartment(employee.getDepartment());
        ExistingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(ExistingEmployee);
    }
    public void deleteEmployee(Long id)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Id not present " + id)
        );
        employeeRepository.delete(employee);
    }
}
