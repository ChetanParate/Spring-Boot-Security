package com.chetan.springboot.springstarter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	private String id;
	private String name;
	private String descriptions;

	public Topic() {
		
	}
	public Topic(String id, String name, String descriptions) {
		super();
		this.id = id;
		this.name = name;
		this.descriptions = descriptions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", descriptions=" + descriptions + "]";
	}
	
	
	
	
	
}
