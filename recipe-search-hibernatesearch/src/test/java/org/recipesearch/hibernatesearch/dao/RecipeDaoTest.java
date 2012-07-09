package org.recipesearch.hibernatesearch.dao;

import java.util.List;

import javax.annotation.Resource;
import org.recipesearch.hibernatesearch.dao.RecipeDao;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.test.BaseTest;

public class RecipeDaoTest extends BaseTest {
    
    @Resource
    private RecipeDao recipeDao;
    
    public void testAllRecipesWithSomeText() {
    	
    	List<Recipe> list = recipeDao.allRecipesByExactText("süßer Senf");
    	assertEquals(1, list.size());      
    }
    
    
    public void testAllRecipesByCook() {
    	
    	List<Recipe> list = recipeDao.allRecipesByCook("Sow", "Boar");
    	assertEquals(1, list.size());      
    }

    
    public void testFindByAuthor() {
    	
        List<Recipe> books = recipeDao.findByAuthor("Mr Bean");
        assertEquals(1, books.size());
        assertEquals(books.get(0).getTitle(), "What an amazon eats");
        
    }
    
   
    
}
