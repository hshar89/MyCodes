package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		
		//Read the spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from the container
		TrafficFortuneService tfs = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Main Program: AroundDemoApp");
		
		myLogger.info("Calling fortune service");
		myLogger.info("My Fortune is: "+tfs.getFortune());
		
		myLogger.info("Finished");
		myLogger.info("\n");
		context.close();	

	}

}
