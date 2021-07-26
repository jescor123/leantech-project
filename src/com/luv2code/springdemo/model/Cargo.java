package com.luv2code.springdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Cargo {
	
	private int id;
	
	private String name;
	
	private List<Empleado> empleados; 
	
	public Cargo() {
		
	}

	public Cargo(int id, String name, List<Empleado> empleados){
		this.id = id;
		this.name = name;
		this.empleados = empleados; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	

}
