
package org.recipesearch.core.security;

import org.recipesearch.core.dao.UserDao;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * An {@link UserDetailsService} that use the UserDao for retrieving user details.
 *
 * @author Lucio Benfante <lucio.benfante@gmail.com>
 */
public class DaoUserDetailsService implements UserDetailsService {

    /** The user DAO. */
    @Resource
    private UserDao userDao;

    /**
     * Get the value of userDao.
     *
     * @return the value of userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * Set the value of userDao.
     *
     * @param userDao new value of userDao
     */
    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     *
     * @param username {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public UserDetails loadUserByUsername(final String username) {
        UserDetails result = userDao.findByUsername(username);
        if (result == null) {
            throw new UsernameNotFoundException("Can't find the user.", username);
        }
        return result;
    }

}
