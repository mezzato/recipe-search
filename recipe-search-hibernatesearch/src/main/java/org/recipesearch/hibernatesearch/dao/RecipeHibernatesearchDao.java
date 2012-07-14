package org.recipesearch.hibernatesearch.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.util.SessionHolder;
import org.springframework.stereotype.Component;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;

@Component
public class RecipeHibernatesearchDao {

	@Resource
	protected SessionFactory sessionFactory;

	public List<Recipe> searchTitleOrText(String titleSearchText, String textSearchText) {

		// Building the Lucene query
		String searchQuery = String.format("title:%s OR text:%s", titleSearchText, textSearchText); // query
																									// string
		QueryParser parser = new QueryParser(Version.LUCENE_31, "title", // default
		new StandardAnalyzer(Version.LUCENE_31) // analyzer used
		);

		org.apache.lucene.search.Query luceneQuery;
		try {
			luceneQuery = parser.parse(searchQuery); // build Lucene query
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchQuery, e);
		}

		//Session session = SessionHolder.getSession();
		//FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession(session);
		//Query query = ftSession.createFullTextQuery(luceneQuery, Recipe.class);

		final List<Recipe> results = search(luceneQuery);

		return results;

	}

	public List<Recipe> searchMultipleFields(String searchText) {

		String[] productFields = { "title", "text" }; // targeted fields

		Map<String, Float> boostPerField = new HashMap<String, Float>(2); // boost
																			// factors
		boostPerField.put("title", (float) 4);
		boostPerField.put("text", (float) 1);

		QueryParser parser = new MultiFieldQueryParser( // build query
														// parser
		Version.LUCENE_31, productFields, new StandardAnalyzer(Version.LUCENE_31), boostPerField);
		org.apache.lucene.search.Query luceneQuery;
		try {
			luceneQuery = parser.parse(searchText);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchText, e);
		}

		final List<Recipe> results = search(luceneQuery);

		return results;

	}

	@SuppressWarnings("unchecked")
	public List<Recipe> search(org.apache.lucene.search.Query luceneQuery) {
		SessionHolder.setSession(sessionFactory.openSession());

		List<Recipe> results = null;

		try {

			Session session = SessionHolder.getSession();
			FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession(session);
			Query query = ftSession.createFullTextQuery(luceneQuery, Recipe.class); // return
																					// matches

			query.setFirstResult(0).setMaxResults(20); // Use pagination

			results = query.list(); // execute the query
			// CollectionUtils.filter(results, new Predicate() {public boolean
			// evaluate(Object o) { return o != null; }});

		} finally {
			SessionHolder.getSession().close();
			SessionHolder.setSession(null);
		}

		return results;
	}
}
