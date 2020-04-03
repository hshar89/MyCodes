package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;

	public CricketCoach() {
       System.out.println("Inside CricketCoach...");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach inside setter....");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do 4 rounds on the ground";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setter for email address");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: setter for team");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

}
