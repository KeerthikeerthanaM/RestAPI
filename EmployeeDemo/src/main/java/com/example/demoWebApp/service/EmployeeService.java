package com.example.demoWebApp.service;

import java.util.List;

import com.example.demoWebApp.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);

}
