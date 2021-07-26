package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
		
	@Column(name="person")
	private int person;
	
	@Column(name="position")
	private int position;
	
	@Column(name="salary")
	private long salary;
	
	
	public Employee() {
		
	}
	
	public Employee(int person, int position, long salary) {
		super();
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

	public int getPerson() {
		return person;
	}



	public void setPerson(int person) {
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

	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", person=" + person + ", position=" + position + ", salary=" + salary + "]";
	}

	

}
