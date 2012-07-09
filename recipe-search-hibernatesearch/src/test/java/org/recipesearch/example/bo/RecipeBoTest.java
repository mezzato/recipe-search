package org.recipesearch.example.bo;

import org.recipesearch.hibernatesearch.bo.RecipeBo;
import org.recipesearch.hibernatesearch.po.Person;
import org.recipesearch.hibernatesearch.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeBoTest extends BaseTest {

	@Autowired
	private RecipeBo recipeBo;

	public void testBookReturned() {
		Person p = recipeBo.resetCook("Chick Corea", "Jazzed skewer");
		assertTrue(p.getFirstName().equals("Hen"));

	}

}
