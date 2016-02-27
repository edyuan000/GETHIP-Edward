package com.gallup.gethip.resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.model.Cart;
import com.gallup.gethip.model.Decoration;
import com.gallup.gethip.resources.CartResource;
@Path("/api/cart")
public class CartResource {
	@GET
	@Produces("application/json")
	public static String alpha() {
		return CartService.getAll();
	}
	@Path("/all")
	@GET
	@Produces("application/json")
	public static String bravo() {
		return CartService.getAll();
	}
	@Path("/id/{productId}")
	@GET
	@Produces("application/json")
	public static String charlie(@PathParam("productId") String pid) {
		return CartService.getId(pid);
	}
	@Path("/dateadded/{addDate}")
	@GET
	@Produces("application/json")
	public static String delta(@PathParam("addDate") String addDate) {
		return CartService.getAddDate(addDate);
	}
	
	@DELETE
	@Produces("text/plain")
	public String delete(@PathParam("cartid") String id){
		return CartService.deleteCart(id);
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Decoration create(@PathParam("cart") Cart c){
		return CartService.createCart(c);
	}
	
	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
	public String update(@PathParam("cart") Cart c){
		return CartService.updateCart(c);
	}
}
