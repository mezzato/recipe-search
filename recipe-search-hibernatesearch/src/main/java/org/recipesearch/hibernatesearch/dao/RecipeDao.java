package org.recipesearch.hibernatesearch.dao;

import java.util.List;
import org.lambico.dao.generic.Dao;
import org.lambico.dao.generic.GenericDao;
import org.recipesearch.hibernatesearch.po.Recipe;


@Dao(entity = Recipe.class)
public interface RecipeDao extends GenericDao<Recipe, Long> {

    List<Recipe> findByAuthor(String author);

    List<Recipe> findByAuthorAndTitle(String author, String title);

    List<Recipe> findByTitle(String title);

    List<Recipe> allRecipesByCook(String cookFirstName, String cookLastName);
    
    List<Recipe> allRecipesByExactText(String searchText);
}
