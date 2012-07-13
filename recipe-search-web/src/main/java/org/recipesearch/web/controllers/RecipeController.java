package org.recipesearch.web.controllers;

import java.util.List;

import org.parancoe.web.validation.Validation;
import org.recipesearch.web.dao.PersonDao;
import org.recipesearch.web.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping({"/person/*.form", "/person/*.html"})
@SessionAttributes(RecipeController.RECIPE_ATTR_NAME)
public class RecipeController {
    public static final String RECIPE_ATTR_NAME = "person";
    public static final String EDIT_VIEW = "person/edit";
    public static final String LIST_VIEW = "person/list";
    @Autowired
    private PersonDao personDao;
    @RequestMapping
    public String edit(@RequestParam("id") Long id, Model model) {
        Person person = personDao.get(id);
        if (person == null) {
            throw new RuntimeException("Person not found");
        }
        model.addAttribute(RECIPE_ATTR_NAME, person);
        return EDIT_VIEW;
    }
    
    @RequestMapping
    @Validation(view=EDIT_VIEW)
    public String save(@ModelAttribute(RECIPE_ATTR_NAME) Person person,
            BindingResult result, SessionStatus status) {
        personDao.store(person);
        status.setComplete();
        return "redirect:list.html";
    }
    @RequestMapping
    public String list(Model model) {
        List<Person> people = personDao.findAll();
        model.addAttribute("people", people);
        return LIST_VIEW;
    }
    @RequestMapping
    public String create(Model model) {
    	 Person person = new Person();
         model.addAttribute(RECIPE_ATTR_NAME, person);
         return EDIT_VIEW;
     }
     @RequestMapping
     public String delete(@RequestParam("id") Long id, Model model) {
         Person person = personDao.get(id);
         if (person == null) {
             throw new RuntimeException("Person not found");
         }
         personDao.delete(person);
         return "redirect:list.html";
     }
 }
