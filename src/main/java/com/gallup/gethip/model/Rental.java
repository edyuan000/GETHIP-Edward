package com.gallup.gethip.model;

import java.awt.Color;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="rental")
public class Rental {
	@DatabaseField(generatedId = true, columnName = "idrental")
	private int idRental;
	
	@DatabaseField(columnName = "price")
	private double price;
	
	@DatabaseField(columnName = "category")
	private String category;
	
	@DatabaseField(columnName = "color")
	private String color;
	
	public Rental(){
		
	}
	
	public void setID(int id){
		this.idRental = id;
	}
	
	public int getID(){
		return this.idRental;
	}
	
	public void setPrice(double p){
		this.price = p;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setCategory(String c){
		this.category = c;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setColor(String c){
		this.color = c;
	}
	
	public String getColor(){
		return color;
	}
	
}
