package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create Student Object
		Student student = new Student();
		// add Student object to the model
		theModel.addAttribute("student", student);
		return "student-form";
	}

	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		// log the input data
		System.out.println(
				"student: " + student.getFirstName() + " " + student.getLastName() + " " + student.getCountry());

		return "student-confirmation";
	}
}
