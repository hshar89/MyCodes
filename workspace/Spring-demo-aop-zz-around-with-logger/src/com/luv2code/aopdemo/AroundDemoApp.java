package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//Read the spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from the container
		TrafficFortuneService tfs = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDemoApp");
		
		System.out.println("Calling fortune service");
		
		System.out.println("My Fortune is: "+tfs.getFortune());
		
		System.out.println("Finished");
		System.out.println("\n");
		context.close();	

	}

}
