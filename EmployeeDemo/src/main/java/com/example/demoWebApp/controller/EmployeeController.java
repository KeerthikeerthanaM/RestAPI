package com.example.demoWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoWebApp.model.Employee;
import com.example.demoWebApp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", service.getAllEmployee());
		return "index.html";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee.html";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";
    }
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") Integer id,Model model)
	{
		Employee employee=service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee.html";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable (value="id") Integer id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}

}
