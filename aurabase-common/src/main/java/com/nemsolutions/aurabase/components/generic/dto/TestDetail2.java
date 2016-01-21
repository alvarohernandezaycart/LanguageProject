package com.nemsolutions.aurabase.components.generic.dto;


public class TestDetail2 {
	
	private Integer id;
	private String name;
	private String surname;
	private String tlfNumber;
	private String address;
	
	public TestDetail2(Integer id, String name, String surname, String tlfNumber, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.tlfNumber = tlfNumber;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTlfNumber() {
		return tlfNumber;
	}

	public void setTlfNumber(String tlfNumber) {
		this.tlfNumber = tlfNumber;
	} 
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
