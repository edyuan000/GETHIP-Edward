package com.gallup.gethip.model;
import com.j256.ormlite.field.DatabaseField;

import javax.xml.bind.annotation.XmlRootElement;


import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="ornaments")
public class Ornament extends Rental{
	@DatabaseField(generatedId = true, columnName = "idOrnament")
	private int idOrnament;
	
	@DatabaseField(columnName = "amount")
	private int amount;
	
	public Ornament(){
		super();
	}
	
	public void setAmount(int a){
		this.amount = a;
	}
	
	public int getAmount(){
		return this.amount;
	}
}
