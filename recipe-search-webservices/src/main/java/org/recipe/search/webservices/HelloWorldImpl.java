package org.recipe.search.webservices;

import javax.ws.rs.core.Response;

public class HelloWorldImpl implements HelloWorld {

	
	public String ping(String input) {
		return input;
	}

	
	public Response modifyJson(JsonBean input) {
		input.setVal2(input.getVal1());
		return Response.ok().entity(input).build();
	}
}
