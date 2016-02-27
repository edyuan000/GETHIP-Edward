package com.gallup.gethip.resources;
import java.sql.SQLException;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Cart;
import com.gallup.gethip.model.Decoration;
import com.gallup.gethip.resources.DatabaseResource;
import com.j256.ormlite.dao.Dao;
public class CartService {
	//GET methods
	public static String getAll() {
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();	
			output = connect.getData("SELECT * FROM cart;");
		} catch (Exception ex) {
			System.out.println("Error retrieving all from cart: " + ex);
		}
		return output;
	}
	public static String getId(String id) {
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();	
			output = connect.getData("SELECT * FROM cart WHERE productid='" + id + "''");
		} catch (Exception ex) {
			System.out.println("Error retrieving item by id: " + ex);
		}
		return output;
	}
	public static String getAddDate(String when) {
		String output;
		output = "";
		try {
			DatabaseResource connect = new DatabaseResource();	
			output = connect.getData("SELECT * FROM cart WHERE dateadded='" + when + "';");
		} catch (Exception ex) {
			System.out.println("Error retrieving item by date: " + ex);
		}
		return output;
	}
	
	public String deleteCart(String id){
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
	
	public Cart createCart(Cart c){
		try {
			Cart cPrime = getDao().createIfNotExists(c);
			if(cPrime == null){
				throw new NullPointerException();
			}else{
				return cPrime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  null;
	}

	public String updateCart(Cart c){
		try {
			int num = getDao().update(c);
			if(num == 1){
				return "Update successful for user " + c.getID();
			}else{
				return "Could not update " + c.getID();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating " + c.getID();
		}
	}

	private Dao<Cart, String> getDao(){
		Dao<Cart, String> dao = DataSourceManager.getInstance().getDao(Cart.class);
		return dao;
	}
}
