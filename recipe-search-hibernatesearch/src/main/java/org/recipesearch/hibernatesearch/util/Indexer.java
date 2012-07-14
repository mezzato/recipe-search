package org.recipesearch.hibernatesearch.util;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.recipesearch.hibernatesearch.po.Recipe;

/**
 * Example 2.8, 2.9
 */
public class Indexer {
	public void indexWithJPA() {
		EntityManager em = org.recipesearch.hibernatesearch.util.EntityManagerHolder.getEntityManager();
		
		//wrap a EntityManager object
		FullTextEntityManager ftem = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		
		ftem.getTransaction().begin();
		
		@SuppressWarnings("unchecked")
		List<Recipe> items = em.createQuery("select i from Recipe i").getResultList();
		
		for (Recipe item : items) {
		    ftem.index(item);  //manually index an Person instance
		}
		
		ftem.getTransaction().commit(); //index are written at commit time
	}
	
	public void indexWithHibernate() {
		Session session = org.recipesearch.hibernatesearch.util.SessionHolder.getSession();
		
		//wrap a Session object
		FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession(session);
		ftSession.getTransaction().begin();
		
		@SuppressWarnings("unchecked")
		List<Recipe> items = session.createCriteria(Recipe.class).list();
		
		for (Recipe item : items) {
		    ftSession.index(item);  //manually index an Person instance
		}
		
		ftSession.getTransaction().commit(); //index are written at commit time
	}
}
