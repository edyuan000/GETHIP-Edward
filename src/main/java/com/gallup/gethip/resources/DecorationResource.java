package com.gallup.gethip.resources;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Decoration;
import com.gallup.gethip.resources.DecorationService;
import com.j256.ormlite.dao.Dao;
@Path("/api/decoration")
public class DecorationResource {
	//[Default] Outputs all decorations (example.com/api)
	@GET
	@Produces("application/json")
	public String getList() {
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
	//Outputs all decorations (example.com/api/all)
	@Path("/all")
	@GET
	@Produces("application/json")
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
	//Outputs all decorations for the specified holiday (example.com/api/holiday/easter)
	@Path("/holiday/{hday}")
	@GET
	@Produces("application/json")
	//Saves holiday name from URL to the String hday
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
	//Outputs the product info of the product with the specified id (example.com/api/22)
	@Path("/id/{productid}")
	@GET
	@Produces("application/json")
	//Saves product id from URL to the String id which will be converted to int in DecorationService method
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
	//Outputs the product info of the product with the specified name (example.com/api/product/Plastic%20Tree) ~ URLs use '%20' instead of spaces
	@Path("/product/{name}")
	@GET
	@Produces("application/json")
	//Saves product name from URL to the String productname
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
	
	@DELETE
	@Produces("text/plain")
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
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
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
	
	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
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
