package com.desginpatterns.strategy;

import com.designpatterns.strategy.controller.CreditCardAlgorithm;
import com.designpatterns.strategy.controller.PayPalAlgorithm;
import com.designpatterns.strategy.controller.ScoreBoard;
import com.designpatterns.strategy.controller.ShoppingCart;
import com.designpatterns.strategy.model.Ballon;
import com.designpatterns.strategy.model.Clown;
import com.designpatterns.strategy.model.Product;
import com.designpatterns.strategy.model.SquareBallon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*ScoreBoard scoreBoard = new ScoreBoard();
       
       System.out.println("Ballon Tapped Score: ");
       scoreBoard.algorithmBase = new Ballon();
       scoreBoard.showScore(10, 5);
       System.out.println("Clown top score: ");
       scoreBoard.algorithmBase = new Clown();
       scoreBoard.showScore(10, 5);
       System.out.println("Square ballon score:");
       scoreBoard.algorithmBase = new SquareBallon();
       scoreBoard.showScore(10, 5);*/
       
	   ShoppingCart cart = new ShoppingCart();
	   Product pants= new Product("234",25);
	   Product shirt = new Product("345",15);
	   
	   cart.addProduct(pants);
	   cart.addProduct(shirt);
	   
	   //payment decision
	   cart.pay(new PayPalAlgorithm("xyx@gmail.com","password"));
       cart.pay(new CreditCardAlgorithm("Test","420420"));
       
	}

}
