package com.designpatterns.interpreter.model;

public class IntToBinaryExp implements Expression {
	
	private int i;
	
	public IntToBinaryExp(int i) {
		this.i = i;
	}
	@Override
	public String interpreter(InterpreterContext context) {
		return context.getBinaryFormat(i);
	}

}
