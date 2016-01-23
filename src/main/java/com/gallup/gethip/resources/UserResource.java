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
import com.gallup.gethip.model.User;
import com.j256.ormlite.dao.Dao;

//The Java class will be hosted at the URI path "/user/{id}"
@Path("/user/{id}")
public class UserResource {
	// The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    public User getIt(@QueryParam("id") String id) {
    	User u = null;
    	try {
			u = getDao().queryForId(id);
			if(u == null){
				throw new NullPointerException("User does not exist");
			}else{
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception user doesn't exist");
		}
    	return u;
        
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteUser(@QueryParam("id") String id){
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
    public User createUser(User u){
    	try {
			User userPrime = getDao().createIfNotExists(u);
			if(userPrime == null){
				throw new NullPointerException("User does not exist");
			}else{
				return userPrime;
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
    public String updateUser(User u){
    	try {
			int num = getDao().update(u);
			if(num == 1){
				return "Update successful for user " + u.getID();
			}else{
				return "Could not update " + u.getID();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + u.getID();
		}
    }
    
    private Dao<User, String> getDao(){
    	Dao<User, String> dao = DataSourceManager.getInstance().getDao(User.class);
    	return dao;
    }
}
