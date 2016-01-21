package com.nemsolutions.language.translation.dto;

import java.util.Date;

public class TranslationDetail{
	private Integer id_translation;
	private String key;
	private String value;
	private Date creationDate;
	private Date modificationDate;
	private Integer id_app;
	private Integer id_language;
	
	
	public TranslationDetail(Integer id_translation, String key, String value, Date creationDate, Date modificationDate,
			Integer id_app, Integer id_language) {
		super();
		this.id_translation = id_translation;
		this.key = key;
		this.value = value;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.id_app = id_app;
		this.id_language = id_language;
	}
	
	public Integer getId_translation() {
		return id_translation;
	}
	public void setId_translation(Integer id_translation) {
		this.id_translation = id_translation;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
		
	public Integer getId_app() {
		return id_app;
	}
	public void setId_app(Integer id_app) {
		this.id_app = id_app;
	}

	public Integer getId_language() {
		return id_language;
	}
	public void setId_language(Integer id_language) {
		this.id_language = id_language;
	}
}