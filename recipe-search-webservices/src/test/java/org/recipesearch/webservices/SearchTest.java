package org.recipesearch.webservices;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.recipesearch.core.po.Recipe;

public class SearchTest {
	private static String endpointUrl;
	
	@BeforeClass
	public static void beforeClass() {
		endpointUrl = System.getProperty("service.url");
	}
	
	@Ignore
	public void testPing() throws Exception {
		WebClient client = WebClient.create(endpointUrl + "/search/echo/SierraTangoNevada");
		Response r = client.accept("text/plain").get();
		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
		String value = IOUtils.toString((InputStream)r.getEntity());
		assertEquals("SierraTangoNevada", value);
	}
	
	@Ignore
	public void testSearch() throws Exception {
		 List<Object> providers = new ArrayList<Object>();
	    providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
	    SearchCriteria searchCriteria = new SearchCriteria();
	    searchCriteria.setSearchText("Weißwurst");
		WebClient client = WebClient.create(endpointUrl + "/search/recipe", providers);
		Response r = client.accept("application/json")
				.type("application/json")
				.post(searchCriteria);
		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
		MappingJsonFactory factory = new MappingJsonFactory();
		JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
		
		TypeReference<ArrayList<Recipe>> retType = new TypeReference<ArrayList<Recipe>>() {};
		
		ArrayList<Recipe> recipes = parser.readValueAs(retType);
		Assert.assertTrue(recipes != null && recipes.size() == 1 && recipes.get(0).getAuthor().equals("Piggy Bank"));
	}
}
