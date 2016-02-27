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
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Decoration;
import com.j256.ormlite.dao.Dao;

@Path("/api/decoration")
public class DecorationResource {
	// [Default] Outputs all decorations (example.com/api)
	@GET
	@Produces("application/json")
	public List<Decoration> getList() {
		// Declared 'output' outside of try/catch so if the database connection
		// failed, the function could still return a string and not break the
		// whole thing
		try {
			return getDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
			// TODO Auto-generated catch block

		}
	}

	// Outputs all decorations (example.com/api/all)
	@Path("/all")
	@GET
	@Produces("application/json")
	public List<Decoration> getAll() {
		// Declared 'output' outside of try/catch so if the database connection
		// failed, the function could still return a string and not break the
		// whole thing
		// String output;
		// output = "";
		// try {
		// DatabaseResource connect = new DatabaseResource();
		// output = connect.getData("SELECT * FROM decorations ORDER BY name;");
		// } catch (Exception ex) {
		// System.out.println("Error retrieving all decorations: " + ex);
		// }
		// return output;
		try {
			return getDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
			// TODO Auto-generated catch block

		}
	}

	// Outputs all decorations for the specified holiday
	// (example.com/api/holiday/easter)
	@Path("/holiday/{hday}")
	@GET
	@Produces("application/json")
	// Saves holiday name from URL to the String hday
	public List<Decoration> getHoliday(@PathParam("hday") String holiday) {
		try {
			return getDao().queryForEq("holiday", holiday);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	// Outputs the product info of the product with the specified id
	// (example.com/api/22)
	@Path("/id/{productid}")
	@GET
	@Produces("application/json")
	// Saves product id from URL to the String id which will be converted to int
	// in DecorationService method
	public List<Decoration> getProductId(@PathParam("productid") String id) {
		try {
			return getDao().queryForEq("productid", id);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	// Outputs the product info of the product with the specified name
	// (example.com/api/product/Plastic%20Tree) ~ URLs use '%20' instead of
	// spaces
	@Path("/product/{name}")
	@GET
	@Produces("application/json")
	// Saves product name from URL to the String productname
	public List<Decoration> getProductName(@PathParam("name") String name) {
		try {
			return getDao().queryForEq("name", name);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Path("/delete")
	@DELETE
	@Produces("text/plain")
	public String deleteDecoration(String id) {
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
	public Decoration createDecoration(Decoration d) {
		try {
			Decoration decPrime = getDao().createIfNotExists(d);
			if (decPrime == null) {
				throw new NullPointerException();
			} else {
				return decPrime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Path("update/{productid}")
	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
	public String updateDecoration(Decoration d) {
		try {
			int num = getDao().update(d);
			if (num == 1) {
				return "Update successful for user " + d.getID();
			} else {
				return "Could not update " + d.getID();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating " + d.getID();
		}
	}

	private Dao<Decoration, String> getDao() {
		Dao<Decoration, String> dao = DataSourceManager.getInstance().getDao(
				Decoration.class);
		return dao;
	}
}
