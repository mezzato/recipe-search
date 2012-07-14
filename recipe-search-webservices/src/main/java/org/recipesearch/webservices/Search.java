package org.recipesearch.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/search")
public interface Search {

	@GET
	@Path("/echo/{input}")
	@Produces(MediaType.TEXT_PLAIN)
	String ping(@PathParam("input") String input);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/recipe")
	public Response searchRecipe(SearchCriteria input);
}
