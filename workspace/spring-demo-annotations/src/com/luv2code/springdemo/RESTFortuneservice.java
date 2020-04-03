package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneservice implements FortuneService {

	@Override
	public String getFortune() {
		return "Make a callout today";
	}

}
