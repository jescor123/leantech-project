package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Person;
import com.luv2code.springdemo.model.Empleado;
import com.luv2code.springdemo.service.EmployeeService;
import com.luv2code.springdemo.service.PersonService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PersonService personService;
	
	// add mapping for get all employees by name
	@GetMapping(value= "/list/{name}", produces= "application/vnd.jcg.api.v1+json")
	public List<Empleado> getEmployessByName(@PathVariable String name) {
		
		List<Employee> employees = employeeService.getEmployees(name);
		List<Empleado> empleados = new ArrayList<>();
		
		for (Employee e : employees) {
			
			Person person = personService.getPerson(e.getPerson());
			Empleado empleado = new Empleado(e.getId(), person, e.getPosition(), e.getSalary());
			empleados.add(empleado);
			
		}
		
		return empleados;		

	}	
	
	
	// add mapping for get all employees
	@GetMapping(value= "/list", produces= "application/vnd.jcg.api.v1+json")
	public List<Empleado> getEmployess() {

		List<Employee> employees = employeeService.getEmployees(null);
		List<Empleado> empleados = new ArrayList<>();

		for (Employee e : employees) {

			Person person = personService.getPerson(e.getPerson());
			Empleado empleado = new Empleado(e.getId(), person, e.getPosition(), e.getSalary());
			empleados.add(empleado);

		}

		return empleados;		

	}	
	
	

	// add mapping for SAVE OR UPDATE employees
	@GetMapping("/saveEmployee/{person}/{position}/{salary}")
	public void saveEmployee(@PathVariable int person, @PathVariable int position, @PathVariable long salary) {
				
		Employee employee = new Employee(person, position, salary);		
		employeeService.saveEmployee(employee);		
		System.out.println("New Employee created");
		
	}
	
	
	// add mapping for DELETE employees
	@GetMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
				
		employeeService.deleteEmployee(id);		
		System.out.println("Employee deleted");
		
	}

	
}
