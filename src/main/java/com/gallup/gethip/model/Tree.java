package com.gallup.gethip.model;

import com.j256.ormlite.field.DatabaseField;

public class Tree extends Rental{
	@DatabaseField(generatedId = true, columnName = "idrental")
	private int idRental;
	
	@DatabaseField(columnName = "price")
	private double price;
	
	public Tree(){
		super();
	}
}
