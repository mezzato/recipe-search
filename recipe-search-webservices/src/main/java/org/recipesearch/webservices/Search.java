package org.recipesearch.webservices;

import java.util.List;

import javax.jws.WebService;

import org.recipesearch.core.po.Recipe;

@WebService
public interface Search {


	String echo(String input);

	
	List<Recipe> searchRecipe(SearchCriteria input);
}
