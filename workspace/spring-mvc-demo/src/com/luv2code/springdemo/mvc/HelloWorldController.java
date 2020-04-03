package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//path becomes /hello/showForm
	 @RequestMapping("/showForm")
	    public String showForm() {
	    	return "helloworld-form";
	    }
	//path becomes /hello/processForm
	    @RequestMapping("/processForm")
	    public String processForm() {
	    	return "helloworld";
	    }
	  @RequestMapping("/processFormVersionTwo")
	  public String convertToUpperCase(HttpServletRequest request, Model model) {
		  String theName= request.getParameter("StudentName");
		  theName = theName.toUpperCase();
		  String result = "Yo! "+theName;
		  model.addAttribute("message",result);
		  return "helloworld";
	  }
	  @RequestMapping("/processFormVersionThree")
	  public String convertToUpperCase2(@RequestParam("StudentName") String theName, Model model) {
		  theName = theName.toUpperCase();
		  String result = "Yo! "+theName;
		  model.addAttribute("message",result);
		  return "helloworld";
	  }
}
