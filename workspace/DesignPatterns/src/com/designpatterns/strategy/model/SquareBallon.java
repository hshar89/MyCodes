package com.designpatterns.strategy.model;

import com.designpatterns.strategy.controller.ScoreAlgorithmBase;

public class SquareBallon extends ScoreAlgorithmBase {

	@Override
	public int calculateScore(int taps, int multiplier) {
		// TODO Auto-generated method stub
		return (taps*multiplier)+40;
	}

}
