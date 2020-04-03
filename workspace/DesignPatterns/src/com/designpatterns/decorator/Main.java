package com.designpatterns.decorator;

import com.designpatterns.decorator.interfaces.IceCream;
import com.designpatterns.decorator.model.BasicIceCream;
import com.designpatterns.decorator.model.ChocolateIceCream;
import com.designpatterns.decorator.model.VanillaIceCream;

public class Main {

	public static void main(String[] args) {
		IceCream bic = new BasicIceCream();
		System.out.println("Basic Ice cream cost "+bic.cost());
		
		//Add Chocolate Ice cream to the order
		IceCream choco = new ChocolateIceCream(bic);
		System.out.println("Chocolate ice cream cost "+choco.cost());
		
		//Adding Vanilla to the order
		IceCream vanillaChoco = new VanillaIceCream(choco);
		System.out.println("Choco vanilla mix cost "+vanillaChoco.cost());
		
		//Adding Vanilla to the order
		IceCream vanillaChocoMint = new VanillaIceCream(vanillaChoco);
		System.out.println("Choco vanilla mint mix cost "+vanillaChocoMint.cost());
	}

}
