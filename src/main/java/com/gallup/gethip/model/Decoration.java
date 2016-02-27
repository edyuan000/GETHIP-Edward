package com.gallup.gethip.model;

import com.j256.ormlite.field.DatabaseField;
import java.awt.Color;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="decoration")
public class Decoration {
	@DatabaseField(generatedId = true, columnName = "productid")
	private int id;
	
	@DatabaseField(columnName = "price")
	private double price;
	
	@DatabaseField(columnName = "holiday")
	private String holiday;
	
	public int getID(){
		return this.id;
	}
	
	public void setPrice(double p){
		this.price = p;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setHoliday(String h){
		this.holiday = h.toUpperCase();
	}
	
	public String getHoliday(){
		return this.holiday;
	}

	
	
}
