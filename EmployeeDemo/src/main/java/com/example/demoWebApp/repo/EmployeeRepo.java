package com.example.demoWebApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoWebApp.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
