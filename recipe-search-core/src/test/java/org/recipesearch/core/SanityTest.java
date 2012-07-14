package org.recipesearch.core;

/**
 * Test for checking the sanity of the application.
 *
 * @author Lucio Benfante
 */
public class SanityTest extends AppBaseTest {

    /** test everything has been loaded properly */
    public void testSanity(){
        assertNotNull(getApplicationContext().getBean("dataSource"));
        assertNotNull(getApplicationContext().getBean("transactionManager"));
        assertNotNull(getApplicationContext().getBean("sessionFactory"));
        assertNotNull(getApplicationContext().getBean("messageSource"));
        assertNotNull(getApplicationContext().getBean("hibernateGenericDaoInstrumentationAspect"));
    }

}
