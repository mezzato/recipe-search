package org.recipesearch.hibernatesearch.test;

import javax.annotation.Resource;

import org.recipesearch.hibernatesearch.bo.RecipeBo;
import org.recipesearch.hibernatesearch.dao.RecipeDao;

public class SanityTest extends BaseTest {

    @Resource
    private RecipeDao recipeD;
    @Resource
    private RecipeBo recipeBO1;

    /**
     * Test the wiring of BO resources.
     */
    public void testBoResources() {
        assertNotNull(recipeBO1);
    }

    /**
     * Test the wiring of DAO resources.
     */
    public void testDaoResources() {
        assertNotNull(recipeD);
    }
}
