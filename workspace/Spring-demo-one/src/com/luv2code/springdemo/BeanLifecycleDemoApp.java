package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
				ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
				//retireve spring bean container
				
				Coach theCoach = context.getBean("myCoach",Coach.class);
			    System.out.println(theCoach.getDailyWorkout());
               context.close();
	}

}
