package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
	   //Load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	  //retrieve bean from spring container
		Coach coach = context.getBean("myCricketCoach",Coach.class);
		//call methods on bean
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkout());
		System.out.println(((CricketCoach) coach).getEmailAddress());
		System.out.println(((CricketCoach)coach).getTeam());
		context.close();
	}

}
