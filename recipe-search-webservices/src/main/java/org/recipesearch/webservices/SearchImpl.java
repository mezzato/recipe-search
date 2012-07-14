package org.recipesearch.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.annotation.Resource;

import org.apache.commons.collections.Transformer;
import org.recipesearch.hibernatesearch.bo.RecipeBo;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchImpl implements Search {

    @Resource
    private RecipeBo recipeBo;
	
	public String ping(String input) {
		return input;
	}

	
	public Response searchRecipe(SearchCriteria input){
		List<Recipe> recipes = this.recipeBo.searchText(input.getSearchText());
		List<org.recipesearch.core.po.Recipe> recipesFromCore = new ArrayList<org.recipesearch.core.po.Recipe>();
		if(recipes != null){
			Transformer transformer = new Transformer() {
				public Object transform(Object input) {
					return ((Recipe) input).getRecipeCore();
				}
			};
			org.apache.commons.collections.CollectionUtils.collect(recipes, transformer , recipesFromCore);
		}
		return Response.ok().entity(recipesFromCore).build();
	}
}
