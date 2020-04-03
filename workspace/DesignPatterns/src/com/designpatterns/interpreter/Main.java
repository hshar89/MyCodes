package com.designpatterns.interpreter;

import com.designpatterns.interpreter.model.Expression;
import com.designpatterns.interpreter.model.IntToBinaryExp;
import com.designpatterns.interpreter.model.IntToHexExpression;
import com.designpatterns.interpreter.model.InterpreterContext;

public class Main {
	
	public InterpreterContext context;
	
	public Main(InterpreterContext context) {
		this.context = context;
	}
	public String interpret(String str) {
		Expression exp = null;
		if(str.contains("Hexa")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Binary")) {
			exp = new IntToBinaryExp(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else {
			return str;
		}
		return exp.interpreter(context);
	}
	public static void main(String[] args) {
		String s1 = "13 in Binary";
		String s2 = "28 in Hexa";
		
		Main m = new Main(new InterpreterContext());
		System.out.println(s1+" = "+m.interpret(s1));
		System.out.println(s2+" = "+m.interpret(s2));

	}

}
