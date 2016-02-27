package com.gallup.gethip;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.spi.container.ContainerListener;
import com.sun.jersey.spi.container.ContainerNotifier;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
public class CORSResponseFilter implements ContainerResponseFilter{
	@Override
	public ContainerResponse filter(ContainerRequest requestContext, ContainerResponse responseContext) {
		System.err.println("Filtering for cors");
		responseContext.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		responseContext.getHttpHeaders().add("Access-COntrol-Allow-Headers", "X-Requested-With, Content-Type");
		
		return responseContext;
	}
}
