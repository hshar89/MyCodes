package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(((TennisCoach)coach).getCoachName());
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println("Before closing context");
		context.close();
		System.out.println("After closing context");

	}

}
