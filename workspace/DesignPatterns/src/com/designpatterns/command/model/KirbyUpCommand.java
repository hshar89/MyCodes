package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class KirbyUpCommand implements Command {
	
	private KirbyCharacterReciever kirby;
	
	public KirbyUpCommand(KirbyCharacterReciever kirby) {
		this.kirby = kirby;
	}

	@Override
	public void execute() {
		kirby.moveUp();
	}

}
