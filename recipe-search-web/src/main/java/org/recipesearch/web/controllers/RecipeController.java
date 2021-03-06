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

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.recipesearch.core.po.Recipe;
import org.recipesearch.web.beans.SearchBean;
import org.recipesearch.web.beans.UserProfileBean;
import org.recipesearch.web.webservices.SearchClient;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.parancoe.web.util.FlashHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/recipe/*.html")
public class RecipeController {

	private static Logger logger = Logger.getLogger(RecipeController.class);
	// @Resource
	// private PersonDao personDao;

	public static final String SEARCH_ATTR_NAME = "searchBean";
	public static final String SEARCH_VIEW = "recipe/search";

	@Resource
	private SearchClient searchClient;

	@RequestMapping(method = RequestMethod.GET)
	public String search(@ModelAttribute(SEARCH_ATTR_NAME) @Valid final SearchBean searchBean, final BindingResult result, final SessionStatus status, final HttpServletRequest req) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String searchText = searchBean.getSearchText();
		
		logger.debug("search text: " + searchText);
		List<Recipe> recipes = null;
		if (StringUtils.isNotBlank(searchText)) {
			recipes = searchClient.getRecipes(searchText);
		} else if(searchText == null){
			searchBean.setSearchText("weißwurst");
		}
		req.setAttribute("recipes", recipes);
		// model.addAttribute("recipes", recipes);
		return SEARCH_VIEW;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView populate(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		Map params = new HashMap();
		// personBo.populateArchive();
		FlashHelper.setRedirectNotice(req, "Popolamento eseguito");
		return new ModelAndView("redirect:search.html", params);
	}

	public Logger getLogger() {
		return logger;
	}
}
