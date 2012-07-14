package org.recipesearch.web;

import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;

/**
 * A context listener that initialize the database of the application (if not
 * initialized yet).
 *
 * @author Jacopo Murador
 * @author Lucio Benfante
 */
public class PopulateInitialDataContextListener extends org.parancoe.web.PopulateInitialDataContextListener {

    public PopulateInitialDataContextListener() {
        // Add here to the clazzToPopulate collection the entity classes you need to populate
        clazzToPopulate.add(Authority.class);
        clazzToPopulate.add(User.class);
    }
}
