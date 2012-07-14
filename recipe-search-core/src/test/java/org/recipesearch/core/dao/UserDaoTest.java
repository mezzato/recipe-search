
package org.recipesearch.core.dao;

import org.recipesearch.core.AppBaseTest;
import org.recipesearch.core.po.User;
import java.util.List;
import javax.annotation.Resource;

/**
 * Tests on methods of the UserDao.
 *
 * @author Lucio Benfante <lucio.benfante@gmail.com>
 */
public class UserDaoTest extends AppBaseTest {
    @Resource
    private UserDao userDao;

    /**
     * Test findAll.
     */
    public void testFindAll() {
        List<User> result = userDao.findAll();
        assertSize(2, result);
        assertEquals(result.get(0).getUsername(), "parancoe");
        assertEquals(result.get(1).getUsername(), "admin");
    }

}
