package com.designpatterns.command.model;

import com.designpatterns.command.interfaces.Command;

public class GameBoy {
	private Command upCommand,downCommand,rightCommand, leftCommand;
	
	public GameBoy(Command upCom, Command down, Command left, Command right) {
		this.upCommand = upCom;
		this.downCommand =down;
		this.leftCommand = left;
		this.rightCommand = right;
	}
	
	public void arrowUp() {
		upCommand.execute();
	}
	public void arrowDown() {
		downCommand.execute();
	}
	public void arrowRight() {
		rightCommand.execute();
	}
	public void arrowLeft() {
		leftCommand.execute();
	}

}
