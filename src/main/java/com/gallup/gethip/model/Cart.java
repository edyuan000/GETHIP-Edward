package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@XmlRootElement
@DatabaseTable(tableName="cart")
public class Cart {
	
	@DatabaseField(generatedId = true, columnName = "cartid")
	private int cartid;
	
	@DatabaseField(columnName = "dateAdded")
	private Date dateAdded;
	
	@DatabaseField(columnName = "install")
	private boolean install;
	
	public void setInstall(boolean b){
		this.install = b;
	}
	
	public int getID(){
		return this.cartid;
	}
	
	public boolean getInstall(){
		return this.install;
	}
	
	public void setDateAdded(Date d){
		this.dateAdded = d;
	}
	
	public Date getDateAdded(){
		return this.dateAdded;
	}
}
