package com.manivash.springboothibernaterest.dao;

import java.util.List;

import com.manivash.springboothibernaterest.model.Employee;

public interface EmployeeDAO {

	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employees);
	
	void delete(int id);
}
