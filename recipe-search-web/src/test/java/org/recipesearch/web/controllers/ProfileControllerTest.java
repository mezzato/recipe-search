package org.recipesearch.web.controllers;

import org.recipesearch.core.dao.UserDao;
import org.recipesearch.core.po.Authority;
import org.recipesearch.core.po.User;
import javax.annotation.Resource;
import org.parancoe.web.test.ControllerTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class ProfileControllerTest extends ControllerTest {

    @Resource
    private ProfileController controller;
    @Resource(name =
    "org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter#0")
    private HandlerAdapter methodHandler;
    @Resource
    private UserDao userDao;

    @Override
    public Class[] getFixtureClasses() {
        return new Class[]{Authority.class, User.class};
    }

    public void testNotNull() {
        assertNotNull(controller);
        assertNotNull(userDao);
    }

    public void testEditAndSaveProfile() throws Exception {
        // Testing the method handler supports the controller
        assertTrue(methodHandler.supports(controller));
        // Retrieve a person for testing
        User user = userDao.findByUsername("parancoe");
        assertNotNull(user);
        SecurityContextHolder.getContext().setAuthentication(
                new TestingAuthenticationToken(user, null));
        // Test edit (showing form)
        resetRequestAndResponse();
        req.setMethod("GET");
        req.setRequestURI("/profile/edit");
        ModelAndView mv = methodHandler.handle(req, res, controller);
        assertEquals("profile/edit", mv.getViewName());
        assertTrue(mv.getModelMap().containsAttribute("userBean"));
        assertNotNull(req.getSession().getAttribute("userBean"));
        // Test store (posting form)
        resetRequestAndResponse();
        req.setMethod("POST");
        req.setRequestURI("/profile");
        req.addParameter("user.firstName", "Mario");
        mv = methodHandler.handle(req, res, controller);
        assertEquals("redirect:profile/edit", mv.getViewName());
        // Check on the DB
        user = userDao.get(user.getId());
        assertNotNull(user);
        assertEquals("Mario", user.getFirstName());
    }
}
