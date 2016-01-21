package com.nemsolutions.aurabase.controller.html.baseexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nemsolutions.aurabase.components.generic.GenericService;
import com.nemsolutions.aurabase.components.generic.dto.TestDetail;

@Controller
@RequestMapping(value = "/baseexample")
public class BaseExampleHtmlController {
	
	private GenericService genericService;
	
	@Autowired
	public void setWoService(GenericService genericService) {
		this.genericService = genericService;
	}	
	
	@RequestMapping(value = "first")
	public ModelAndView first() {	
		
		ModelAndView mv = new ModelAndView("baseexample/first/firstDetail");
		TestDetail t = genericService.getTest(1);
		mv.addObject("t", t);
		return mv;
	}

	@RequestMapping(value = "second")
	public ModelAndView second() {	  
		return new ModelAndView("baseexample/second/secondDetail");
	}	
	

	@RequestMapping(value = "first/firstSummary")
	public ModelAndView fiSummary() {
		TestDetail t = genericService.getTest(2);
		ModelAndView mv = new ModelAndView("baseexample/first/firstDetail");
		mv.addObject("t", t);
		return mv;
	}
	
	@RequestMapping(value = "first/firstOutsourcing")
	public ModelAndView fiOutsourcing() {	
		return new ModelAndView("baseexample/first/firstDetail");
	}
	
	
	@RequestMapping(value = "second/secondSummary")
	public ModelAndView secondSummary() {
		return new ModelAndView("baseexample/second/secondDetail");
	}
}