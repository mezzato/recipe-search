package org.recipesearch.hibernatesearch.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.recipesearch.hibernatesearch.po.Person;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.util.Padder;
import org.recipesearch.hibernatesearch.util.SessionHolder;
import org.springframework.stereotype.Component;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.DateTools;
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

		// Session session = SessionHolder.getSession();
		// FullTextSession ftSession =
		// org.hibernate.search.Search.getFullTextSession(session);
		// Query query = ftSession.createFullTextQuery(luceneQuery,
		// Recipe.class);

		final List<Recipe> results = search(luceneQuery, sessionFactory);

		return results;

	}
	
	public List<Recipe> searchRecipesByPriceRange(BigDecimal lowerPrice, BigDecimal upperPrice) {
		Padder padder = new Padder(10,1);
		String fromValue = padder.pad(lowerPrice); 
		String toValue =  padder.pad(upperPrice);
		final List<Recipe> results = searchRange("price",  fromValue, toValue);
		return results;
	}

	public List<Person> searchAuthorByLastname(String lastName) {
		// Building the Lucene query
		String searchQuery = String.format("lastName:%s", lastName);
		QueryParser parser = new QueryParser(Version.LUCENE_31, "lastName", new StandardAnalyzer(Version.LUCENE_31));

		org.apache.lucene.search.Query luceneQuery;
		try {
			luceneQuery = parser.parse(searchQuery); // build Lucene query
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchQuery, e);
		}

		final List<Person> results = search(luceneQuery, sessionFactory);

		return results;
	}

	public List<Person> searchAuthorByBirthday(Date fromDate, Date toDate) {

		final String sFrom = DateTools.dateToString(fromDate, DateTools.Resolution.DAY);
		final String sTo = DateTools.dateToString(toDate, DateTools.Resolution.DAY);
		String fieldName = "birthDate";

		/*
		 * Term lowerTerm = new Term(fieldName, sFrom); Term upperTerm = new
		 * Term(fieldName, sTo); TermRangeFilter filter = new
		 * TermRangeFilter(fieldName, lowerTerm.text(), upperTerm.text(), true,
		 * true); luceneQuery = new MatchAllDocsQuery(); //new FilteredQuery(
		 * new MatchAllDocsQuery(), filter); luceneQuery = new FilteredQuery(
		 * new MatchAllDocsQuery(), filter); //Query query = new
		 * RangeQuery(startTerm, endTerm, inclusive);
		 */


		final List<Person> results = searchRange(fieldName,  sFrom, sTo);
		return results;

	}
	
	public <T> List<T> searchRange(String fieldName, String fromValue, String toValue) {
		
		org.apache.lucene.search.Query luceneQuery;
		String searchQuery = String.format("%s:[%s TO %s]", fieldName, fromValue, toValue);
		QueryParser parser = new QueryParser(Version.LUCENE_31, fieldName, new StandardAnalyzer(Version.LUCENE_31));

		try {
			luceneQuery = parser.parse(searchQuery); // build Lucene query
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse query: " + searchQuery, e);
		}

		final List<T> results = search(luceneQuery, sessionFactory);
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

		final List<Recipe> results = search(luceneQuery, sessionFactory);

		return results;

	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> search(org.apache.lucene.search.Query luceneQuery, SessionFactory sessionFactory) {
		SessionHolder.setSession(sessionFactory.openSession());

		List<T> results = null;

		try {

			Session session = SessionHolder.getSession();
			FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession(session);
			Query query = ftSession.createFullTextQuery(luceneQuery, Person.class, Recipe.class); // return
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
