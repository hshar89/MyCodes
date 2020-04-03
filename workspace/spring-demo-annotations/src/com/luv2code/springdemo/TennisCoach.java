package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//("thatSillyCoach")
@Scope("singleton")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	//You can use properties file to provide values like these
	@Value("${foo.name}")
	private String coachName;
	
	public String getCoachName() {
		return coachName;
	}
    //Dependency injection using field injection
    /*
    @Autowired
    private FortuneService fortuneService;
    */
    //define init method
	@PostConstruct
	public void myStartUpStuff() {
		System.out.println("TennisCoach: Inside do my startup stuff");
	}
	//define destroy method
	@PreDestroy
	public void doCleanUpStuff() {
		System.out.println("TennisCoach: Inside do my cleanup stuff");
	}
    public TennisCoach() {
    	System.out.println("Inside TenniCoach default constructor");
    }
    //Autowiring using constructor
    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
    	this.fortuneService = fortuneService;
    }*/
	@Override
	public String getDailyWorkout() {
		
		return "Strenthen your grip";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside TenniCoach autowired setter method");
		this.fortuneService = fortuneService;
	}
	//Dependency injection using any random method
	/*@Autowired
	public void doSomeRandomStuff(FortuneService fortuneService) {
		System.out.println("Inside TennisCoach: do some random stuff");
		this.fortuneService = fortuneService;
	}*/

}
