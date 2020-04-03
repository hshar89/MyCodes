package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//The below line will scan all beans in the package and call their constructors
//Even though no method was defined for that bean
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
  @Bean
  public FortuneService sadFortuneService() {
	  return new SadFortuneService();
  }
  @Bean
  public Coach swimCoach() {
	  SwimCoach myswimCoach = new SwimCoach(sadFortuneService());
	  return myswimCoach;
  }
}
