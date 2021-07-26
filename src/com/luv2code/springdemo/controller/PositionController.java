package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Person;
import com.luv2code.springdemo.entity.Position;
import com.luv2code.springdemo.model.Cargo;
import com.luv2code.springdemo.model.Empleado;
import com.luv2code.springdemo.service.EmployeeService;
import com.luv2code.springdemo.service.PersonService;
import com.luv2code.springdemo.service.PositionService;

//@Controller
@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PersonService personService;
	
	
		
	@GetMapping(value= "/list", produces= "application/vnd.jcg.api.v1+json")
	List<Cargo>  showListPositionsWithEmployyesOrderBySalary(){

		List<Cargo> cargos = new ArrayList<>();
		List<Position> positions = new ArrayList<>();
		List<Empleado> empleados = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();
		
		positions = positionService.getPositions();

		for (Position p : positions){
			employees = employeeService.getEmployees();

			for (Employee e : employees){

				Person person = personService.getPerson(e.getPerson());
				Empleado empleado = new Empleado(e.getId(), person, e.getPosition(), e.getSalary());                                         
				empleados.add(empleado);

			} 

			Cargo cargo = new Cargo(p.getId(), p.getName(), empleados);
			cargos.add(cargo);                

		} 

		return cargos;

	}          
	
	
}
