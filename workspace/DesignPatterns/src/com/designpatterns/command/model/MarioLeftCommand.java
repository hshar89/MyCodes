package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class MarioLeftCommand implements Command {

	private MarioCharacterReciever mario;

	public MarioLeftCommand(MarioCharacterReciever mario) {
		this.mario = mario;
	}

	@Override
	public void execute() {
		mario.moveleft();
	}

}
