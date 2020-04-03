package com.designpatterns.facade.model;

public class CPU {
	
	public void freeze() {
		System.out.println("Computer freezing...");
	}
	public void jump(long position) {
		System.out.println("Jumping to position "+position);
	}
	public void execute() {
		System.out.println("CPU executing commands");
	}
}
