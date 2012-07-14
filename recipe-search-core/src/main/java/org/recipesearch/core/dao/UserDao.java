package org.recipesearch.core.dao;

import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;
import java.util.List;
import org.lambico.dao.generic.Dao;
import org.lambico.dao.generic.GenericDao;

/**
 * The DAO interface for the UserProfile entity.
 *
 * @author <a href="mailto:enrico.giurin@gmail.com">Enrico Giurin</a>
 * @author <a href="mailto:michele.franzin@seesaw.it">Michele Franzin</a>
 * @version $Revision: 2c4d46632a31 $
 */
@Dao(entity = User.class)
public interface UserDao extends GenericDao<User, Long> {

    /**
     * Returns the unique user identified by username and password.
     * @param username The username
     * @param password The password
     * @return The user identified by the username and password, or null.
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * Returns the unique user identified by username.
     * @param username The username.
     * @return The user identified by the username.
     */
    User findByUsername(String username);

    /**
     * Returns all the users identified by partial username.
     * @param username The partial username.
     * @return The users with usernames that match the partial username.
     */
    List<User> findByPartialUsername(String username);

    /**
     *  Returns all the authorities associated to a partial username.
     * @param username compare upper-case and like mode
     * @return The autorities associated to users with the partial username.
     */
    List<Authority> findAuthoritiesByPartialUsername(String username);
}
