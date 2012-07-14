package org.recipesearch.hibernatesearch.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.util.SessionHolder;

/**
 * Example 2.10, 2.11, 2.12, 2.13
 */
public class HibernateSearchTest extends BaseTest {

	public void testSearch() {

		// Building the Lucene query
		String searchQuery = "title:Eggs OR text:exotic"; // query string
		QueryParser parser = new QueryParser(Version.LUCENE_31, "title", // default
																			// field
		new StandardAnalyzer(Version.LUCENE_31) // analyzer used
		);

		org.apache.lucene.search.Query luceneQuery;
		try {
			luceneQuery = parser.parse(searchQuery); // build Lucene query
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchQuery, e);
		}

		Session session = SessionHolder.getSession();
		FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession(session);
		Query query = ftSession.createFullTextQuery(luceneQuery, Recipe.class);

		@SuppressWarnings("unchecked")
		final List<Recipe> results = launchSearchTest(luceneQuery);

		// CollectionUtils.filter(results, new Predicate() {public boolean
		// evaluate(Object o) { return o != null; }});

		assertEquals(results.size(), 2);

	}

	
	public void skip_testSearchMultipleFields() {
		
		// Building the Lucene query
		String searchQuery = "εὐαγγέλιον";

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
			luceneQuery = parser.parse(searchQuery);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchQuery, e);
		}

		@SuppressWarnings("unchecked")
		final List<Recipe> results = launchSearchTest(luceneQuery);
		assertEquals(results.size(), 1);

	}

	private List<Recipe> launchSearchTest(org.apache.lucene.search.Query luceneQuery) {
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
