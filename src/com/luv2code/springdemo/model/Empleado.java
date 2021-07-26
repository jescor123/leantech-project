package com.luv2code.springdemo.model;

import com.luv2code.springdemo.entity.Person;

public class Empleado {
	
	private int id;
	
	private Person person;
	
	private int position;
	
	private long salary;
	
	public Empleado() {
		
	}
	

	public Empleado(int id, Person person, int position, long salary) {
		super();
		this.id = id;
		this.person = person;
		this.position = position;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	

}
