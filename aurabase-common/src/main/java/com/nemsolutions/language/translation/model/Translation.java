package com.nemsolutions.language.translation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tbl_lang_translation")
public class Translation{
	private Integer id_translation;
	private String key;
	private String value;
	private Date creationDate;
	private Date modificationDate;
	private Integer id_app;
	private Integer id_language;
	
	
	public Translation(String key, String value, Date creationDate, Date modificationDate,
			Integer id_app, Integer id_language) {
		super();
		this.key = key;
		this.value = value;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.id_app = id_app;
		this.id_language = id_language;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "translation_id", nullable=false)
	public Integer getId_translation() {
		return id_translation;
	}
	public void setId_translation(Integer id_translation) {
		this.id_translation = id_translation;
	}
	
	@Column(name = "translation_key", nullable=false)	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Column(name = "translation_value")	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name = "translation_cDate")
	@Type(type="timestamp")
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column(name = "translation_mDate")
	@Type(type="timestamp")
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	@Column(name = "translation_id_app", nullable=false)	
	public Integer getId_app() {
		return id_app;
	}
	public void setId_app(Integer id_app) {
		this.id_app = id_app;
	}
	
	@Column(name = "translation_id_language", nullable=false)
	public Integer getId_language() {
		return id_language;
	}
	public void setId_language(Integer id_language) {
		this.id_language = id_language;
	}
	
	
	
}