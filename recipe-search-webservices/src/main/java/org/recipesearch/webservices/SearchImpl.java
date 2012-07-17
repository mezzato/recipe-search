package org.recipesearch.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.Transformer;
import org.recipesearch.core.po.Recipe;
import org.recipesearch.core.webservices.Search;
import org.recipesearch.core.webservices.SearchCriteria;
import org.recipesearch.hibernatesearch.bo.RecipeBo;

public class SearchImpl implements Search {

    @Resource
    private RecipeBo recipeBo;
	
    @Override
	public String echo(String input) {
		return input;
	}

	
	@Override
	public List<Recipe> searchRecipe(SearchCriteria input){
		List<org.recipesearch.hibernatesearch.po.Recipe> recipes = this.recipeBo.searchText(input.getSearchText());
		List<org.recipesearch.core.po.Recipe> recipesFromCore = new ArrayList<org.recipesearch.core.po.Recipe>();
		if(recipes != null){
			Transformer transformer = new Transformer() {
				@Override
				public Object transform(Object input) {
					return ((org.recipesearch.hibernatesearch.po.Recipe) input).getRecipeCore();
				}
			};
			org.apache.commons.collections.CollectionUtils.collect(recipes, transformer , recipesFromCore);
		}
		return recipesFromCore;
	}

}
