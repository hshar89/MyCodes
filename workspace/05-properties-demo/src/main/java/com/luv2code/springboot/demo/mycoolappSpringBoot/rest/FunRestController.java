package com.luv2code.springboot.demo.mycoolappSpringBoot.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
	@Value("${coach.name}")
	private String coachName;
	@Value("${coach.team}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: "+coachName+" TeamName: "+teamName;
	}
	@GetMapping("/")
	public String sayhello() {
		return "Hello World! Time on server is: "+LocalDateTime.now();
	}
	//expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	@GetMapping("/fortune")
	public String getAFortune() {
		return "Today is your lucky day";
	}
	
}
