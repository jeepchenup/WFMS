package com.wfms.spring.mvc.annotation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		System.out.println("----");
		return "home";
	}
}
