package com.designpatterns.template.model;

public class FootballGame extends Game {

	@Override
	void initialize() {
		System.out.println("Football Game initializing ...");

	}

	@Override
	void startPlay() {
		System.out.println("Football game starting ...");

	}

	@Override
	void endPlay() {
		System.out.println("Football game ending ...");

	}

	@Override
	protected void addCharacterToTheGame() {
		// TODO Auto-generated method stub
		
	}

}
