package com.designpatterns.template;

import com.designpatterns.template.model.EndlessRunnerGame;
import com.designpatterns.template.model.FootballGame;
import com.designpatterns.template.model.Game;

public class Main {

	public static void main(String[] args) {
		
		Game game = new FootballGame();
		game.play();
		game = new EndlessRunnerGame();
		game.play();

	}

}
