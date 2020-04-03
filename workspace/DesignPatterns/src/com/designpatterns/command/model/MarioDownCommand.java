package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class MarioDownCommand implements Command {
	
	private MarioCharacterReciever mario;
	
	public MarioDownCommand(MarioCharacterReciever mario) {
		this.mario = mario;
	}

	@Override
	public void execute() {
		mario.moveDown();
	}

}
