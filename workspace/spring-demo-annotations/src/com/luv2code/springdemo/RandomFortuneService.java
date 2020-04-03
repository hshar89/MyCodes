package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	@Value("${fortune.values}")
    private String data[]; //{"Random 1","Random 2","Random 3","The journey is the reward"};
    
    private Random random = new Random();
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index];
	}

}
