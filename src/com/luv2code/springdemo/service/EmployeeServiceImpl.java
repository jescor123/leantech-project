package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.EmployeeDAO;
import com.luv2code.springdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees(String search) {
		
		return employeeDAO.getEmployees(search);
		
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeDAO.deleteEmployee(id);
		
	}

	@Override
	@Transactional
	public List<Employee> getEmployeesByPosition(int position) {
		
		return employeeDAO.getEmployeesByPosition(position);
		
	}
	
}
