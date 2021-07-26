package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
}