package com.nemsolutions.aurabase.components.generic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_gen_test")
public class Test {
	
	private Integer id;
	private String name;
	
	public Test(){
		this.id = null;
		this.name = null;
	}
	
	public Test(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
