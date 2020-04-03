package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @RequestMapping("showForm")
	public String showForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
    @RequestMapping("processForm")
    public String processForm(
    		@Valid @ModelAttribute("customer") Customer customer,
    		BindingResult bindingResult) {
    	System.out.println("lastName: |"
    			+customer.getLastName()+"|");
    	//Check the log on this object for generic messages on different exceptions
    	System.out.println("bindingresult: "+bindingResult);
    	if(bindingResult.hasErrors()) {
    		return "customer-form";
    	}
    	return "customer-confirmation";
    }
    //All web request received by our controller will be pre processed here
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
    	StringTrimmerEditor ste = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, ste);
    }
}
