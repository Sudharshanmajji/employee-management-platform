package com.sudharshan.EmployeeManagementSystem;

import com.sudharshan.EmployeeManagementSystem.entity.Employee;
import com.sudharshan.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void saveEmployee()
	{
		Employee employee=new Employee();
		employee.setName("Sudharshan");
		employee.setDepartment("CSE");
		employee.setEmail("majjisudharshan@gmail.com");
		employee.setSalary(80000.50);

		employeeRepository.save(employee);
	}

}
