package org.recipesearch.hibernatesearch.test;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.lambico.test.spring.hibernate.DBTest;
import org.recipesearch.hibernatesearch.po.Person;
import org.recipesearch.hibernatesearch.po.Recipe;
import org.recipesearch.hibernatesearch.util.Indexer;
import org.recipesearch.hibernatesearch.util.SessionHolder;

public abstract class BaseTest extends DBTest {

	/** The logger for this class. */
	private static Logger logger = Logger.getLogger(BaseTest.class);

	// @SuppressWarnings(value = "unchecked")
	// protected ApplicationContext getTestContext() {
	// BeanFactoryLocator bfl = SingletonBeanFactoryLocator.getInstance(
	// "beanRefFactory_test.xml");
	// BeanFactoryReference bf = bfl.useBeanFactory("org.parancoe.example");
	// ApplicationContext lctx = (ApplicationContext) bf.getFactory();
	// Map daoMap = (Map) lctx.getBean("daoMap");
	// Map ldaos = DaoUtils.getDaos(lctx);
	// daoMap.putAll(ldaos);
	// return lctx;
	// }
	@Override
	public Class[] getFixtureClasses() {
		return new Class[] { Person.class, Recipe.class };
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:org/lambico/spring/dao/hibernate/genericDao.xml", "classpath:org/lambico/spring/dao/hibernate/applicationContextBase.xml", "classpath:database_test.xml", "classpath:applicationContext.xml" };
	}

	@Override
	public void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();

		Session session = sessionFactory.openSession();
		SessionHolder.setSession(session);

		Indexer indexer = new Indexer();

		session.beginTransaction();

		try {
			indexer.indexWithHibernate();
		} catch (Exception e) {
			logger.error(e);
			logger.debug("Rolling back the database transaction");
			session.getTransaction().rollback();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e) { /* do nothing */
				logger.info("Can't close the session! (ignore it)");
			}
		}

		// Lucene index

	}
}
