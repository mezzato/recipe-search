package org.recipesearch.webservices;

import java.util.List;

import org.recipesearch.core.po.Recipe;
import org.recipesearch.core.webservices.Search;
import org.recipesearch.core.webservices.SearchCriteria;

public class SearchClient {
	private Search searchService;

	public void setSearchService(Search searchService) {
		this.searchService = searchService;
	}

	public List<Recipe> getRecipes(String text) {
		
		SearchCriteria criteria = new SearchCriteria();
		criteria.setSearchText(text);
		return searchService.searchRecipe(criteria);
	}
}