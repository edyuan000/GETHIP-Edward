package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Cart;
import com.j256.ormlite.dao.Dao;

@Path("/api/cart")
public class CartResource {
	@GET
	@Produces("application/json")
	public List<Cart> getList() {
		try {
			return getDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
			// TODO Auto-generated catch block

		}
	}

	@Path("/all")
	@GET
	@Produces("application/json")
	public List<Cart> getAll() {
		try {
			return getDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
			// TODO Auto-generated catch block

		}
	}

	@Path("/id/{cartid}")
	@GET
	@Produces("application/json")
	public List<Cart> getId(@PathParam("cartid") String id) {
		try {
			return getDao().queryForEq("cartid", id);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Path("/dateadded/{addDate}")
	@GET
	@Produces("application/json")
	public List<Cart> getAddDate(@PathParam("addDate") String date) {
		try {
			return getDao().queryForEq("DATEADDED", date);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Path("/delete")
	@DELETE
	@Produces("text/plain")
	public String deleteCart(String id) {
		try {
			int num = getDao().deleteById(id);
			if (num == 1) {
				return "Delete successful";
			} else {
				return "Unable to delete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error in sql statement";
		}
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Cart createCart(Cart c) {
		try {
			Cart cPrime = getDao().createIfNotExists(c);
			if (cPrime == null) {
				throw new NullPointerException();
			} else {
				return cPrime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Path("/update/{cartid}")
	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
	public String updateCart(Cart c) {
		try {
			int num = getDao().update(c);
			if (num == 1) {
				return "Update successful for user " + c.getID();
			} else {
				return "Could not update " + c.getID();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating " + c.getID();
		}
	}

	private Dao<Cart, String> getDao() {
		Dao<Cart, String> dao = DataSourceManager.getInstance().getDao(
				Cart.class);
		return dao;
	}
}
