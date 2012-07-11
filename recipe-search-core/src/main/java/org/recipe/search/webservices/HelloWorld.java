package org.recipe.search.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public interface HelloWorld {

	@GET
	@Path("/echo/{input}")
	@Produces(MediaType.TEXT_PLAIN)
	String ping(@PathParam("input") String input);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/jsonBean")
	public Response modifyJson(JsonBean input);
}
