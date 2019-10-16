package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//public List<Employee> findAllByOrderByLastNameAsc();
	public List<Employee> findByFirstnameContainsOrLastnameContainsAllIgnoreCase(String name, String lName);
}
