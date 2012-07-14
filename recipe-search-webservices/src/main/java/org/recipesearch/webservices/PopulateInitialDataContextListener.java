package org.recipesearch.webservices;

import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;
import org.recipesearch.hibernatesearch.po.Person;
import org.recipesearch.hibernatesearch.po.Recipe;

/**
 * A context listener that initialize the database of the application (if not
 * initialized yet).
 */
public class PopulateInitialDataContextListener extends org.parancoe.web.PopulateInitialDataContextListener {

    public PopulateInitialDataContextListener() {
        // Add here to the clazzToPopulate collection the entity classes you need to populate
        clazzToPopulate.add(Person.class);
        clazzToPopulate.add(Recipe.class);
    }
}
