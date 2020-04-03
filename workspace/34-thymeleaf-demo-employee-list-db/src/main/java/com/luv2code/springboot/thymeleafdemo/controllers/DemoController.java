package com.luv2code.springboot.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
   
	//create a mapping for '/hello'

	@GetMapping("/hello")
	public String getHello(Model theModel) {
		theModel.addAttribute("theDate",new java.util.Date());
		return "helloworld";
	}
}
