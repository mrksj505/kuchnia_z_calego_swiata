package com.kuchnia3;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MealController {
	
	@Autowired
	private MealRepository repo;
	
	@RequestMapping(value = "/image", method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/kopytka.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
	
	@RequestMapping("/")
	public ModelAndView listMeals(ModelAndView mav) {
		List<Meal> listMeal = repo.getAllMeals();
		String image_name = "kopytka";
		mav.addObject("image_name",image_name);
		mav.addObject("listMeal", listMeal);
	    mav.setViewName("index");
	    return mav;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView newMeal(ModelAndView mav) {
		Meal newMeal = new Meal();
		mav.addObject("meal", newMeal);
		mav.setViewName("meal_form");
		return mav;
	} 
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editMeal(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Meal meal = repo.getMeal(id);
		// Tutaj przechodzi do strony meal_form
		ModelAndView mav = new ModelAndView("meal_form");
		
		mav.addObject("meal", meal);
		
		return mav;
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
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteMeal(@RequestParam Integer id) {
		repo.deleteMeal(id);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/search")
	public ModelAndView searchMeal(@RequestParam String keyword) {
	    List<Meal> result = repo.searchMeal(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
	}
	
}
