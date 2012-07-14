package org.recipesearch.web.controllers;

import org.recipesearch.core.dao.UserDao;
import org.recipesearch.core.po.User;
import org.recipesearch.web.beans.UserProfileBean;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.LockMode;
import org.lambico.dao.spring.hibernate.HibernateGenericDao;
import org.parancoe.web.util.FlashHelper;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Controller for managing the user profile.
 *
 * @author Lucio Benfante
 */
@Controller
@RequestMapping({"/profile"})
@SessionAttributes(ProfileController.USER_ATTR_NAME)
public class ProfileController {

    public static final String USER_ATTR_NAME = "userBean";
    public static final String EDIT_VIEW = "profile/edit";
    private static final String[] PROFILE_USER_PROPERTIES = new String[]{"username", "firstName",
        "lastName", "password"};
    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        UserProfileBean userBean = new UserProfileBean();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        ((HibernateGenericDao) userDao).getHibernateTemplate().lock(user, LockMode.NONE);
        User editUser = new User();
        copySelectedProperties(editUser, user, PROFILE_USER_PROPERTIES);
        userBean.setUser(editUser);
        model.addAttribute(USER_ATTR_NAME, userBean);
        return EDIT_VIEW;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public String save(@ModelAttribute(USER_ATTR_NAME) @Valid final UserProfileBean userBean,
            final BindingResult result, final SessionStatus status, final HttpServletRequest req)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (result.hasErrors()) {
            return EDIT_VIEW;
        }
        User editUser = userBean.getUser();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (StringUtils.isNotBlank(userBean.getNewPassword())) {
            Md5PasswordEncoder encoder = new Md5PasswordEncoder();
            editUser.setPassword(encoder.encodePassword(
                    userBean.getNewPassword(), editUser.getUsername()));
        }
        copySelectedProperties(user, editUser, PROFILE_USER_PROPERTIES);
        userDao.store(user);
        FlashHelper.setRedirectNotice(req, "flash.profileUpdated");
        status.setComplete();
        return "redirect:profile/edit";
    }

    private void copySelectedProperties(Object dest, Object src, String[] properties) throws
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        for (String property : properties) {
            BeanUtils.setProperty(dest, property, BeanUtils.getProperty(src, property));
        }
    }
}
