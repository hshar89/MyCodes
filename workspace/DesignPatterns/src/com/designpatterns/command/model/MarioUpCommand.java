package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class MarioUpCommand implements Command {

	private MarioCharacterReciever mario;
	
	
	public MarioUpCommand(MarioCharacterReciever mario) {
		this.mario = mario;
	}

	@Override
	public void execute() {
		mario.moveUp();
	}

}
