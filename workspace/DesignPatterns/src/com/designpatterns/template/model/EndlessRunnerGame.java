package com.designpatterns.template.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EndlessRunnerGame extends Game {

	@Override
	void initialize() {
		System.out.println("Endless Runner Game initializing ...");

	}

	@Override
	void startPlay() {
		System.out.println("Endless Runner Game starting ...");
		playerWantsANewCharacter();
	}

	@Override
	void endPlay() {
		System.out.println("Endless Runner Game ending....");

	}

	@Override
	protected void addCharacterToTheGame() {
		System.out.println("Adding new character to the game");
	}
	public boolean playerWantsANewCharacter() {
		String answer = getUserInput();
		if(answer.toLowerCase().startsWith("y")) {
			return true;
		}
		return false;
	}
	private String getUserInput() {
		String answer = null;
		System.out.println("Would you like to add new character to the game....");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		}catch(Exception e){
			System.out.println("IO Error");
		}
		if(answer ==null) {
			return "no";
		}
		return "yes";
	}

}
