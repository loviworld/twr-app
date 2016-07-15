package com.lovi.twr.model;

import org.springframework.data.mongodb.core.mapping.Document;
import com.lovi.twr.common.model.EntityBase;

@Document
public class JobSeeker extends EntityBase{

	private String email;	
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
