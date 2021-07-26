package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
		
}
