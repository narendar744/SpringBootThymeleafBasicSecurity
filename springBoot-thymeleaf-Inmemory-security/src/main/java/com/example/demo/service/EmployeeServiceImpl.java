package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> findAll() {
		
		//return repository.findAllByOrderByLastNameAsc();
		
		return repository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
repository.save(employee);		
	}

	@Override
	public void deleteById(int id) {
repository.deleteById(id);		
	}

	@Override
	public List<Employee> searchBy(String theName) {
		
		List<Employee> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = repository.findByFirstnameContainsOrLastnameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
	



}
