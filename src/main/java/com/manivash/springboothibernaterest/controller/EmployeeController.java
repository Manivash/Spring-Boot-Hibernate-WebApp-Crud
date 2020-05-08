package com.manivash.springboothibernaterest.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.manivash.springboothibernaterest.model.Employee;
import com.manivash.springboothibernaterest.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("employeesList");
		mav.addObject("list",employeeService.get());
		return mav;
	}
	
	@RequestMapping("/showEmployeeForm")
	public ModelAndView showEmployeeForm() {
		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("employee",new Employee());
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") Employee employee){
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.save(employee);
		mav.addObject("list",employeeService.get());
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.delete(id);
		mav.addObject("list",employeeService.get());
		return mav;
	}
	
	@RequestMapping("/employee")
	public ModelAndView get(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView("employeesAdd");
		Employee employeeObj = employeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee with id =" + id);
		}
		mav.addObject("employee", employeeObj);
		return mav;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}
	
	
}
