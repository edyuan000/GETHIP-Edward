package com.gallup.gethip.resources;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Rental;
import com.gallup.gethip.model.User;
import com.j256.ormlite.dao.Dao;

//The Java class will be hosted at the URI path "/rental/{id}"
@Path("/rental/{id}")
public class RentalResource {
	// The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    public Rental getIt(@QueryParam("id") String id) {
    	Rental r = null;
    	try {
			r = getDao().queryForId(id);
			if(r == null){
				throw new NullPointerException("User does not exist");
			}else{
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw error message
		}
    	return r;
        
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteRental(@QueryParam("id") String id){
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
    public Rental createRental(Rental r){
    	try {
			Rental rentalPrime = getDao().createIfNotExists(r);
			if(rentalPrime == null){
				throw new NullPointerException();
			}else{
				return rentalPrime;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  null;
    }
    
    @PUT
    @Produces("text/plain")
    @Consumes("application/json")
    public String updateRental(Rental r){
    	try {
			int num = getDao().update(r);
			if(num == 1){
				return "Update successful for user " + r.getID();
			}else{
				return "Could not update " + r.getID();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + r.getID();
		}
    }
    
    private Dao<Rental, String> getDao(){
    	Dao<Rental, String> dao = DataSourceManager.getInstance().getDao(Rental.class);
    	return dao;
    }
}
