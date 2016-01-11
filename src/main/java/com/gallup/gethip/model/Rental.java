package com.gallup.gethip.model;

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
	
	public Rental(){
		
	}
	
}
