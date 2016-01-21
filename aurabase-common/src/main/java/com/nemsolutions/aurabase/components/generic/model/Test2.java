package com.nemsolutions.aurabase.components.generic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_gen_test2")
public class Test2 {
	
	private Integer id;
	private String name;
	private String surname;
	private String tlfNumber;
	private String address;
	
	

	public Test2(){
		this.id = null;
		this.name = null;
		this.surname = null;
		this.tlfNumber = null;;
		this.address = null;
		
	}
	
	public Test2(Integer id, String name, String surname, String tlfNumber, String address) {
		super(); 
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.tlfNumber = tlfNumber;
		this.address = address;
	}

	@Id
	@Column(name = "tst_id", nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "tst_name", nullable=false)	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	@Column(name = "tst_surname", nullable=false)	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Column(name = "tst_tlfNumber", nullable=false)	
	public String getTlfNumber() {
		return tlfNumber;
	}

	public void setTlfNumber(String tlfNumber) {
		this.tlfNumber = tlfNumber;
	}
	@Column(name = "tst_address", nullable=false)	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
