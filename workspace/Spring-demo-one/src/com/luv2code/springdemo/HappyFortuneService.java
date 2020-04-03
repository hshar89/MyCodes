package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService{
    private static Random random = new Random();
	@Override
	public String getFortune() {
		int r = random.nextInt(3);
		return FortuneService.fortunes[r];
	}
    
}
