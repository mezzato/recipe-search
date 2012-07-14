package org.recipesearch.web.controllers;

import org.recipesearch.core.dao.AuthorityDao;
import org.recipesearch.core.dao.UserDao;
import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;
import org.recipesearch.web.beans.AuthorityCheckBox;
import org.recipesearch.web.beans.UserBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.parancoe.web.util.FlashHelper;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * A controller for managing users.
 * 
 * @author Lucio Benfante
 */
@Controller
@RequestMapping({"/admin/users"})
@SessionAttributes(AdminUsersController.USER_ATTR_NAME)
public class AdminUsersController {

    public static final String USER_ATTR_NAME = "userBean";
    public static final String EDIT_VIEW = "admin/users/edit";
    public static final String LIST_VIEW = "admin/users/list";
    @Resource
    private UserDao userDao;
    @Resource
    private AuthorityDao authorityDao;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("user.id");
    }

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("userId") Long id, Model model) {
        UserBean userBean = null;
        User user = userDao.get(id);
        if (user != null) {
            userBean = new UserBean();
            List<Authority> authorities = authorityDao.findAll();
            for (Authority authority : authorities) {
                AuthorityCheckBox authorityCheckBox = new AuthorityCheckBox();
                authorityCheckBox.setAuthority(authority);
                if (user.getUserAuthorities().contains(authority)) {
                    authorityCheckBox.setChecked(true);
                }
                userBean.getAuthorityCheckBoxes().add(authorityCheckBox);
            }
            userBean.setUser(user);
        } else {
            throw new RuntimeException("User not found");
        }
        model.addAttribute(USER_ATTR_NAME, userBean);
        return EDIT_VIEW;
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public String save(@ModelAttribute(USER_ATTR_NAME) @Valid UserBean userBean,
            BindingResult result, SessionStatus status, HttpServletRequest req) {
        if (result.hasErrors()) {
            return EDIT_VIEW;
        }
        User user = userBean.getUser();
        if (StringUtils.isNotBlank(userBean.getNewPassword())) {
            Md5PasswordEncoder encoder = new Md5PasswordEncoder();
            user.setPassword(encoder.encodePassword(
                    userBean.getNewPassword(), user.getUsername()));
        }
        user.getUserAuthorities().clear();
        for (AuthorityCheckBox authorityCheckBox : userBean.getAuthorityCheckBoxes()) {
            if (authorityCheckBox.isChecked()) {
                user.getUserAuthorities().add(authorityCheckBox.getAuthority());
            }
        }
        userDao.store(user);
        FlashHelper.setRedirectNotice(req, "flash.userUpdated");
        status.setComplete();
        return "redirect:";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return LIST_VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {
        UserBean userBean = new UserBean();
        // Authority authority = authorityDao.findByRole("ROLE_PARANCOE");
        User user = new User();
        List<Authority> authorities = authorityDao.findAll();
        for (Authority authority : authorities) {
            AuthorityCheckBox authorityCheckBox = new AuthorityCheckBox();
            authorityCheckBox.setAuthority(authority);
            userBean.getAuthorityCheckBoxes().add(authorityCheckBox);
        }
        user.setPassword("changeIt");
        userBean.setUser(user);
        model.addAttribute(USER_ATTR_NAME, userBean);
        return EDIT_VIEW;
    }

    @RequestMapping(value = "/{userId}", method = {RequestMethod.DELETE})
    public String delete(@PathVariable("userId") Long id, Model model) {
        User user = userDao.get(id);
        if (user != null) {
            userDao.delete(user);
        } else {
            throw new RuntimeException("User not found");
        }
        return "redirect:";
    }
}
