package com.designpatterns.interpreter.model;

public class IntToHexExpression implements Expression {
	
	private int i;
	public IntToHexExpression(int i) {
		this.i = i;
	}
	@Override
	public String interpreter(InterpreterContext context) {
		return context.getHexFormat(i);
	}

}
