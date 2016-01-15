package com.gallup.gethip.model;

import com.j256.ormlite.field.DatabaseField;
import java.awt.Color;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="trees")
public class Tree extends Rental{
	@DatabaseField(generatedId = true, columnName = "idTree")
	private int idTree;
	
	@DatabaseField(columnName = "height")
	private double height;
	
	public Tree(){
		super();
	}
	
	public void setHeight(double h){
		this.height = h;
	}
	
	public double getHeight(){
		return this.height;
	}
}
