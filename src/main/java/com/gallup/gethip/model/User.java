package com.gallup.gethip.model;


import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="users")
public class User {
	
	@DatabaseField(generatedId = true, columnName = "id")
	private int id;
	
	
	@DatabaseField(columnName = "email")
	private String email;
	
	@DatabaseField(columnName = "password")
	private String password;
	
	
	
	public User(){
		
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	public void setPassword(String p){
		this.password = p;
	}
	
}

