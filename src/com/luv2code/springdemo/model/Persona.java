package com.luv2code.springdemo.model;


public class Persona {
	
	private int id;
	
	private String name;
	
	private String lastname;
	
	private String address;
	
	private long cellphone;
	
	private String cityname;
	
	public Persona() {
		
	}

	public Persona(int id, String name, String lastname, String address, long cellphone, String cityname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.cellphone = cellphone;
		this.cityname = cityname;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCellphone() {
		return cellphone;
	}

	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	
	

}
