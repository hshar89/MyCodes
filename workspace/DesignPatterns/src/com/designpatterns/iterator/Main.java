package com.designpatterns.iterator;

import java.util.ArrayList;

import com.designpatterns.iterator.interfaces.Catalouge;
import com.designpatterns.iterator.interfaces.Iterator;
import com.designpatterns.iterator.model.DevStoreCatalouge;
import com.designpatterns.iterator.model.GeekyStoreCatalouge;
import com.designpatterns.iterator.model.Product;

public class Main {

	public static void main(String[] args) {
		
		Catalouge dsc = new DevStoreCatalouge();		
		Catalouge gsc = new GeekyStoreCatalouge();
		Iterator it = dsc.createIterator();
		while(it.hasNext()) {
			Product pro = (Product)it.next();
			System.out.print(pro.getName()+" ");
			System.out.print(pro.getDescription()+" ");
			System.out.println(pro.getPrice());
		}
		System.out.println("------------------");
		it = gsc.createIterator();
		while(it.hasNext()) {
			Product pro = (Product)it.next();
			System.out.print(pro.getName()+" ");
			System.out.print(pro.getDescription()+" ");
			System.out.println(pro.getPrice());
		}

	}

}
