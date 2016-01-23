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
import com.gallup.gethip.model.Tree;
import com.j256.ormlite.dao.Dao;

public class TreeResource {
	// The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    public Tree getIt(@QueryParam("idTree") String id) {
    	Tree t = null;
    	try {
			t = getDao().queryForId(id);
			if(t == null){
				throw new NullPointerException("Tree does not exist");
			}else{
				return t;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception tree doesn't exist");
		}
    	return t;
        
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteTree(@QueryParam("id") String id){
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
    public Tree createTree(Tree t){
    	try {
			Tree treePrime = getDao().createIfNotExists(t);
			if(treePrime == null){
				throw new NullPointerException();
			}else{
				return treePrime;
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
    public String updateTree(Tree t){
    	try {
			int num = getDao().update(t);
			if(num == 1){
				return "Update successful for user " + t.getID();
			}else{
				return "Could not update " + t.getID();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + t.getID();
		}
    }
    
    private Dao<Tree, String> getDao(){
    	Dao<Tree, String> dao = DataSourceManager.getInstance().getDao(Tree.class);
    	return dao;
    }
}
