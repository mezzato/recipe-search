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

import java.text.ParseException;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.parancoe.web.util.FlashHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe/*.html")
public class RecipeController {

    private static Logger logger = Logger.getLogger(RecipeController.class);
    //@Resource
    //private PersonDao personDao;
    
    //@Resource
    //private PersonBo personBo;

    @RequestMapping
    public ModelAndView search(HttpServletRequest req, HttpServletResponse res) {
        Map params = new HashMap();
        //params.put("people", personDao.findAll());
        return new ModelAndView("recipe/search", params);
    }

    @RequestMapping
    public ModelAndView populate(HttpServletRequest req, HttpServletResponse res) throws ParseException {
        Map params = new HashMap();
        //personBo.populateArchive();
        FlashHelper.setRedirectNotice(req, "Popolamento eseguito");
        return new ModelAndView("redirect:search.html", params);
    }

    public Logger getLogger() {
        return logger;
    }
}
