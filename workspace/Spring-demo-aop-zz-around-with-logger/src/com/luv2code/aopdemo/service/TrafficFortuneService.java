package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted exception happened");
			e.printStackTrace();
		}
		
		//return a fortune
		return "Get Stuck in traffic b****";
	}
}
