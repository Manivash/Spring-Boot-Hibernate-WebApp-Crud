package com.manivash.springboothibernaterest.service;

import java.util.List;

import com.manivash.springboothibernaterest.model.Employee;

public interface EmployeeService {

	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employees);
	
	void delete(int id);
}
