package com.gallup.gethip.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Ornament;
import com.j256.ormlite.dao.Dao;

public class OrnamentResource {
	// The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    public Ornament getIt(@QueryParam("idOrnament") String id) {
    	Ornament o = null;
    	try {
			o = getDao().queryForId(id);
			if(o == null){
				throw new NullPointerException("Ornament does not exist");
			}else{
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ornament doesn't exist, SQL exception");
		}
    	return o;
        
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteOrnament(@QueryParam("idOrnament") String id){
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
    public Ornament createTree(Ornament o){
    	try {
			Ornament oPrime = getDao().createIfNotExists(o);
			if(oPrime == null){
				throw new NullPointerException();
			}else{
				return oPrime;
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
    public String updateOrnament(Ornament o){
    	try {
			int num = getDao().update(o);
			if(num == 1){
				return "Update successful for user " + o.getID();
			}else{
				return "Could not update " + o.getID();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + o.getID();
		}
    }
    
    private Dao<Ornament, String> getDao(){
    	Dao<Ornament, String> dao = DataSourceManager.getInstance().getDao(Ornament.class);
    	return dao;
    }
}
