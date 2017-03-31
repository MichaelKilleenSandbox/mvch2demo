package com.mjk.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="helloworld")
public class HelloWorldController {
	
	@RequestMapping(value="/")
	public ModelAndView helloWorld() {
		ModelAndView mav = new ModelAndView("helloworld");
		mav.addObject("greeting", "Hello World!!!");
		mav.addObject("name", "place holder");
		//model.addAttribute("greeting", "Hello World");
		return mav;
	}
}
