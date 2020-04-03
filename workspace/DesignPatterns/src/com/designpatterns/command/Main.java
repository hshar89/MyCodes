package com.designpatterns.command;

import com.designpatterns.command.interfaces.Command;
import com.designpatterns.command.model.GameBoy;
import com.designpatterns.command.model.MarioCharacterReciever;
import com.designpatterns.command.model.MarioDownCommand;
import com.designpatterns.command.model.MarioLeftCommand;
import com.designpatterns.command.model.MarioRightCommand;
import com.designpatterns.command.model.MarioUpCommand;

public class Main {

	public static void main(String[] args) {
		
		MarioCharacterReciever mario = new MarioCharacterReciever();
		mario.setName("Mario");
		Command upcom = new MarioUpCommand(mario);
		Command downcom = new MarioDownCommand(mario);
		Command leftcom = new MarioLeftCommand(mario);
		Command rightcom = new MarioRightCommand(mario);
		GameBoy console = new GameBoy(upcom,downcom,leftcom,rightcom);
		console.arrowLeft();
		console.arrowUp();
		console.arrowDown();
		console.arrowRight();

	}

}
