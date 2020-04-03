package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Run 30 mins on track";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
    
	public void doMyStartupStuff() {
		System.out.println("Inside the init method");
	}
	
	public void doMyDestroyStuff() {
		System.out.println("Inside the destroy method");
	}
}
