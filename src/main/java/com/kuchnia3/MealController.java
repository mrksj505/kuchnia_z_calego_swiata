package com.kuchnia3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MealController {
	
	@Autowired
	private MealRepository repo;
	
	@RequestMapping("/")
	public ModelAndView listMeals(ModelAndView mav) {
	 
	    List<Meal> listMeal = repo.getAllMeals();
	    mav.addObject("listMeal", listMeal);
	    mav.setViewName("index");
	    return mav;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editMeal(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Meal meal = repo.getMeal(id);
		ModelAndView model = new ModelAndView("meal_form");
		
		model.addObject("meal", meal);
		
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveMeal(@ModelAttribute Meal meal) {
		if(meal.getId_meal()==null) {
			repo.addMeal(meal.getMeal_name(), meal.getKind(), meal.getCountry(), meal.getMinutes_to_cook(), meal.getRecipe());
		}
		else {
			repo.updateMeal(meal.getId_meal(),meal.getMeal_name(), meal.getKind(), meal.getCountry(), meal.getMinutes_to_cook(), meal.getRecipe());
		}
		return new ModelAndView("redirect:/");
	}
	
}
