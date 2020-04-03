package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		FortuneService fs = new HappyFortuneService();	
		Coach bc = new BaseballCoach(fs);
		//use the object
        System.out.println(bc.getDailyWorkout());
        System.out.println(bc.getDailyFortune());
	}

}
