package com.sudharshan.EmployeeManagementSystem.controller;
import com.sudharshan.EmployeeManagementSystem.dto.EmployeeRequest;
import com.sudharshan.EmployeeManagementSystem.dto.EmployeeResponse;
import com.sudharshan.EmployeeManagementSystem.entity.Employee;
import com.sudharshan.EmployeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
     private final EmployeeService employeeService;
     private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper)
    {
        this.employeeService=employeeService;
        this.modelMapper=modelMapper;
    }
    @PostMapping
    public EmployeeResponse addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest)
    {
        Employee employee=modelMapper.map(employeeRequest,Employee.class);
        Employee savedEmployee=employeeService.addEmployee(employee);
        return modelMapper.map(savedEmployee,EmployeeResponse.class);
    }
//    @GetMapping
//    public List<EmployeeResponse> getAllEmployees() {
//
//        List<Employee> employees = employeeService.getAllEmployees();
//
//        return employees.stream()
//                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
//                .toList();
//    }
@GetMapping
public List<EmployeeResponse> getAllEmployees(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "name") String sortBy) {

    Page<Employee> employeePage =employeeService.getAllEmployees(page,size,sortBy);

    return employeePage.getContent()
            .stream()
            .map(employee ->
                    modelMapper.map(
                            employee,
                           EmployeeResponse.class))
            .toList();
}


    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id)
    {
        Employee employee=employeeService.getEmployeeById(id);

        return modelMapper.map(employee,EmployeeResponse.class);
    }
//    @GetMapping
//
//        public List<EmployeeResponse> getSortedEmployees(@RequestParam(defaultValue = "name") String sortBy)
//        {
//            List<Employee> employees=employeeService.getAllEmployeesSorted(sortBy);
//
//            return employees.stream()
//                    .map(employee ->modelMapper.map(employee,EmployeeResponse.class)).toList();
//        }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployeeById(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee employee=modelMapper.map(employeeRequest,Employee.class);
        Employee updatedEmployee=employeeService.updateEmployee(id,employee);
        return modelMapper.map(updatedEmployee,EmployeeResponse.class);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id)
    {

        employeeService.deleteEmployee(id);
    }
}
