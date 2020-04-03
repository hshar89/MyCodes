package com.designpatterns.template.model;

public abstract class Game {
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	void loadAssets() {
		System.out.println("Assets are loading...");
	}
	public final void play() {
		loadAssets();
		initialize();
		startPlay();
		if(addGameCharacter()==true) {
			addCharacterToTheGame();
		}
		endPlay();
	}
	//Hooked on template method
	protected abstract void addCharacterToTheGame();
	boolean addGameCharacter() {
		return true;
	}
}
