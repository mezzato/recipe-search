// Copyright 2006-2007 The Parancoe Team
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.recipesearch.web.controllers;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.parancoe.plugins.security.Authority;
import org.parancoe.plugins.security.AuthorityDao;
import org.parancoe.plugins.security.User;
import org.parancoe.plugins.security.UserDao;
import org.parancoe.web.validation.Validation;
import org.recipesearch.web.beans.AuthorityCheckBox;
import org.recipesearch.web.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.providers.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller for managing users.
 * 
 * @author Lucio Benfante
 */
@Controller
@RequestMapping({"/admin/users/*.form", "/admin/users/*.html"})
@SessionAttributes(AdminUsersController.USER_ATTR_NAME)
public class AdminUsersController {

    public static final String USER_ATTR_NAME = "userBean";
    public static final String EDIT_VIEW = "admin/users/edit";
    public static final String LIST_VIEW = "admin/users/list";
    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthorityDao authorityDao;

    @RequestMapping
    public String edit(@RequestParam("id") Long id,
            Model model) {
        UserBean userBean = null;
        User user = userDao.get(id);
        if (user != null) {
            userBean = new UserBean();
            List<Authority> authorities = authorityDao.findAll();
            for(Authority authority: authorities) {
                AuthorityCheckBox authorityCheckBox = new AuthorityCheckBox();
                authorityCheckBox.setAuthority(authority);
                if (user.getAuthorities().contains(authority)) {
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

    @RequestMapping
    @Validation(view=EDIT_VIEW)
    public String save(@ModelAttribute(USER_ATTR_NAME) UserBean userBean,
            BindingResult result, SessionStatus status) {
        User user = userBean.getUser();
        if (StringUtils.isNotBlank(userBean.getNewPassword())) {
            Md5PasswordEncoder encoder = new Md5PasswordEncoder();
            user.setPassword(encoder.encodePassword(
                    userBean.getNewPassword(), user.getUsername()));
        }
        user.getAuthorities().clear();
        for (AuthorityCheckBox authorityCheckBox: userBean.getAuthorityCheckBoxes()) {
            if (authorityCheckBox.isChecked()) {
                user.getAuthorities().add(authorityCheckBox.getAuthority());
            }
        }
        userDao.store(user);
        status.setComplete();
        return "redirect:list.html";
    }

    @RequestMapping
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView(LIST_VIEW);
        List<User> users = userDao.findAll();
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping
    public String create(Model model) {
        UserBean userBean = new UserBean();
        // Authority authority = authorityDao.findByRole("ROLE_PARANCOE");
        User user = new User();
        List<Authority> authorities = authorityDao.findAll();
        for(Authority authority: authorities) {
            AuthorityCheckBox authorityCheckBox = new AuthorityCheckBox();
            authorityCheckBox.setAuthority(authority);
            userBean.getAuthorityCheckBoxes().add(authorityCheckBox);
        }
        userBean.setUser(user);
        model.addAttribute(USER_ATTR_NAME, userBean);
        return EDIT_VIEW;
    }

    @RequestMapping
    public String delete(@RequestParam("id") Long id, Model model) {
        User user = userDao.get(id);
        if (user != null) {
            userDao.delete(user);
        } else {
            throw new RuntimeException("User not found");
        }
        return "redirect:list.html";
    }
}
