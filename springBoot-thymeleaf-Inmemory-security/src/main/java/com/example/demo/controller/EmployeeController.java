package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/list")
	public String listEmployeee(Model theModel) {
		List<Employee> theEmployees=service.findAll();
		theModel.addAttribute("employee", theEmployees);
		return "employee/list-employee";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmploye= new Employee();
		theModel.addAttribute("employee", theEmploye);
		return "employee/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam ("employeeId")int id ,Model theModel) {
		Employee theEmployee= service.findById(id);
		theModel.addAttribute("employee", theEmployee);
		return "employee/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String showFormForDelete(@RequestParam ("employeeId")int id ) {
		service.deleteById(id);
		return "redirect:/employee/list";	
	}
	@PostMapping("save")
	public  String saveEmployee(@ModelAttribute("employee") Employee theEmployee ) {
		service.save(theEmployee);
		return "redirect:/employee/list";
		
	}
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
	
		List<Employee> theEmployees = service.searchBy(theName);
		
		theModel.addAttribute("employees", theEmployees);
		
		return "/employee/list-employee";
		
	}
	

}
