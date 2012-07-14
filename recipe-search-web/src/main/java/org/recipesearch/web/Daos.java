package org.recipesearch.web;

import org.lambico.dao.DaoProvider;

/**
 * Interface for the DAO Provider. Doesn't require an implementation.
 * Simply add methods for the DAOs you need to use.
 * The convention for the methods is get<dao_bean_id>.
 */
public interface Daos extends DaoProvider {
}
