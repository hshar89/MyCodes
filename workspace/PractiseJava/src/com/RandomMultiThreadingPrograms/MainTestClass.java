package com.RandomMultiThreadingPrograms;

public class MainTestClass {

	public static void main(String[] args) {
		
		Geek1 geek1 = new Geek1();
		Geek2 geek2a = new Geek2(geek1);
		Geek2 geek2b = new Geek2(geek1);
		Geek3 geek3 = new Geek3(geek1);
		Thread t1 = new Thread(geek1,"Geek1");
		Thread t2 = new Thread(geek2a,"Geek2a");
		Thread t3 = new Thread(geek2b,"Geek2b");
		Thread t4 = new Thread(geek3,"Geek3");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t4.start();

	}

}
