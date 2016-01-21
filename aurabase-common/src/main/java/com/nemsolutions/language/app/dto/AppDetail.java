package com.nemsolutions.language.app.dto;

public class AppDetail{
	private Integer id_app;
	private String name;
	private String technology;

	public AppDetail(Integer id_app, String name, String technology) {
		super();
		this.id_app = id_app;
		this.name = name;
		this.technology = technology;
	}
	
	public Integer getId_app() {
		return id_app;
	}

	public void setId_app(Integer id_app) {
		this.id_app = id_app;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

}
