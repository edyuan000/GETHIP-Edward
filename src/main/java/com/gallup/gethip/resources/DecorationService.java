package com.gallup.gethip.resources;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Decoration;
import com.gallup.gethip.resources.DatabaseResource;
import com.j256.ormlite.dao.Dao;
public class DecorationService {
	//GET Methods
	public String getAll() {
		//Declared 'output' outside of try/catch so if the database connection failed, the function could still return a string and not break the whole thing
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();	
			output = connect.getData("SELECT * FROM decorations ORDER BY name;");
		} catch (Exception ex) {
			System.out.println("Error retrieving all decorations: " + ex);
		}
		return output;
	}
	public String getHoliday(String h) {
		String output;
		output = "";
		
		try {
			List<Decoration> list = getDao().queryForEq("holiday", h);
			DatabaseResource connect = new DatabaseResource();
			output = connect.getData("SELECT * FROM decorations WHERE holiday = '" + h + "' ORDER BY name;");
		} catch (Exception ex) {
			System.out.println("Error retrieving decorations by holiday: " + ex);
		}
		return output;
	}
	public String getProductId(String i) {
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();
			//String i does not need to be an int because it needs to concat with a string for MySQL
			output = connect.getData("SELECT * FROM decorations WHERE productid = '" + i + "';");
		} catch (Exception ex) {
			System.out.println("Error retrieving decorations by product id: " + ex);
		}
		return output;
	}
	public String getProductName(String n) {
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();
			output = connect.getData("SELECT * FROM decorations WHERE name = '" + n + "';");
		} catch (Exception ex) {
			System.out.println("Error retrieving decorations by product name: " + ex);
		}
		return output;
	}
	
	
	public String deleteDecoration(String id){
    	try {
			int num = getDao().deleteById(id);
			if(num == 1){
				return "Delete successful";
			}else{
				return "Unable to delete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error in sql statement";
		}
    }
	
	public Decoration createDecoration(Decoration d){
		try {
			Decoration decPrime = getDao().createIfNotExists(d);
			if(decPrime == null){
				throw new NullPointerException();
			}else{
				return decPrime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  null;
	}

	public String updateDecoration(Decoration d){
		try {
			int num = getDao().update(d);
			if(num == 1){
				return "Update successful for user " + d.getID();
			}else{
				return "Could not update " + d.getID();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating " + d.getID();
		}
	}

	private Dao<Decoration, String> getDao(){
		Dao<Decoration, String> dao = DataSourceManager.getInstance().getDao(Decoration.class);
		return dao;
	}
}