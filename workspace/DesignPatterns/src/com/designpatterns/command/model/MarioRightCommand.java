package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class MarioRightCommand implements Command {
	
	private MarioCharacterReciever mario;

	public MarioRightCommand(MarioCharacterReciever mario) {
		this.mario = mario;
	}
	@Override
	public void execute() {
		mario.moveRight();
	}

}
