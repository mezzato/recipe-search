package org.recipesearch.web.controllers;

import javax.annotation.Resource;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.mock.web.MockHttpServletRequest;
import org.parancoe.web.test.ControllerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerAdapter;

public class HomeControllerTest extends ControllerTest {

    @Autowired
    private HomeController controller;
    @Resource
    private HandlerAdapter methodHandler;

    public void testConfiguration() {
        assertNotNull(controller);
        assertNotNull(methodHandler);
    }

    public void testWelcome() throws Exception {
        resetRequestAndResponse();
        req.setMethod("GET");
        req.setRequestURI("/home/welcome.html");
        req = new MockHttpServletRequest("GET", "/home/welcome.html");
        ModelAndView mv = methodHandler.handle(req, res, controller);
        assertEquals("welcome", mv.getViewName());
        assertNotNull(mv.getModel().get("something"));
    }
}
