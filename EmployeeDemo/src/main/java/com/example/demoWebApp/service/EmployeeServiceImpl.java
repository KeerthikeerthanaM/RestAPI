package com.example.demoWebApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWebApp.model.Employee;
import com.example.demoWebApp.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();

	}

	@Override
	public void saveEmployee(Employee employee) {
		this.repo.save(employee);

	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = repo.findById(id);
		Employee employee = null;
		if (optional.isPresent())
		{
			employee = optional.get();
		}
		else
		{
			throw new RuntimeException("Employee is not present with given id::" + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		this.repo.deleteById(id);
	
		
	}

}
