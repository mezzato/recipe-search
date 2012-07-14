
package org.recipesearch.core;

import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;
import org.lambico.test.spring.hibernate.DBTest;

/**
 * A base class for basic persistence example tests.
 *
 * @author lucio
 */
public abstract class AppBaseTest extends DBTest {

    @Override
    public Class[] getFixtureClasses() {

        return new Class[]{Authority.class, User.class };
        
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{
                    "classpath:org/lambico/spring/dao/hibernate/genericDao.xml",
                    "classpath:org/lambico/spring/dao/hibernate/applicationContextBase.xml",
                    "classpath:database_test.xml",
                    "classpath:applicationContext_test.xml"
                };
    }

    @Override
    public void onSetUpBeforeTransaction() throws Exception {
        this.getJdbcTemplate().execute("SET REFERENTIAL_INTEGRITY FALSE");
        super.onSetUpBeforeTransaction();
        this.getJdbcTemplate().execute("SET REFERENTIAL_INTEGRITY TRUE");
    }


}
