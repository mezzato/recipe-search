package org.recipesearch.hibernatesearch.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

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
	
	public void testPersonViaHibernatesearchReturned() {
	    //Clear all fields
		Calendar cal = GregorianCalendar.getInstance();
	    cal.clear();
	    //2007-04-25
	    cal.set(Calendar.YEAR, 2007);
	    cal.set(Calendar.MONTH, Calendar.APRIL);
	    cal.set(Calendar.DATE, 25);
	    
	    List<Person> authors = recipeBo.searchAuthorByBirthday(cal.getTime());
		
		assertTrue(authors != null && authors.size() == 2);
		
	}

}
