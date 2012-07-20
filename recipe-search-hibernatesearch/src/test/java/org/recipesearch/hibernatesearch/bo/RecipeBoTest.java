package org.recipesearch.hibernatesearch.bo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.recipesearch.hibernatesearch.bo.RecipeBo;
import org.recipesearch.hibernatesearch.po.Person;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeBoTest extends BaseTest {

	@Autowired
	private RecipeBo recipeBo;

	public void testBookReturned() {
		Person p = recipeBo.resetCook("Chick Corea", "Jazzed skewer");
		assertTrue(p.getFirstName().equals("Hen"));
	}

	public void testRecipeViaHibernatesearchReturned() {
		List<Recipe> recipes = recipeBo.searchText("Weißwurst");

		assertTrue(recipes != null && recipes.size() == 1 && recipes.get(0).getAuthor().equals("Piggy Bank"));
	}

	public void testPersonByBirthdayViaHibernatesearchReturned() {
		// Clear all fields
		Calendar cal = Calendar.getInstance();
		cal.clear();
		// 2007-04-25
		cal.set(Calendar.YEAR, 2007);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DATE, 25);

		List<Person> authors = recipeBo.searchAuthorByBirthday(cal.getTime());

		assertTrue(authors != null && authors.size() == 2);

	}

	public void testRecipeByPriceRangeViaHibernatesearchReturned() {
		List<Recipe> results = recipeBo.searchRecipesByPriceRange(new BigDecimal(1000), new BigDecimal(1000.9));
		assertTrue(results != null && results.size() == 2);

	}

}
