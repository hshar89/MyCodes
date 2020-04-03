package com.Multithreading;
class Runner1 implements Runnable{
	public void startRunning() {
		for(int i=0;i<10;i++) {
			System.out.println("Runner1: "+i);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startRunning();
	}
}
class Runner2 implements Runnable{
	public void startRunning() {
		for(int i=0;i<10;i++) {
			System.out.println("Runner2: "+i);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startRunning();
	}
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Thread t1 = new Thread(new Runner1());
	Thread t2= new Thread(new Runner2());
	
    t1.start();
    t2.start();
	}

}
