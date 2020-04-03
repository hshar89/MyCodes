package com.designpatterns.flyweight;

import com.designpatterns.flyweight.model.Circle;
import com.designpatterns.flyweight.model.ShapeFactory;

public class Main {
	
	private static final String[] colors = {"Red","Blue","Yellow","Black"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			Circle c1 = (Circle)ShapeFactory.getCircle(getRandomColor());
			c1.setX(getRandomX());
			c1.setY(getRandomY());
			c1.setRadius(200);
			c1.draw();
		}
	}
	private static String getRandomColor() {
		return colors[(int)(Math.random()*colors.length)];
	}
	
	private static int getRandomX() {
		return (int)(Math.random()*100);
	}
	
	private static int getRandomY() {
		return (int)(Math.random()*100);
	}
}
