package com.Multithreading;
class Runner11 extends Thread{
	public void startRunning() throws InterruptedException {
		for(int i=0;i<10;i++) {
			System.out.println("Runner1: "+i);
			Thread.sleep(100);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			startRunning();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Runner12 extends Thread{
	public void startRunning() throws InterruptedException {
		for(int i=0;i<100;i++) {
			System.out.println("Runner2: "+i);
			Thread.sleep(100);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			startRunning();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Runner11 r1 = new Runner11();
      Runner12 r2 = new Runner12();
      r1.start();
      r2.start();
      
      try {
		r1.join();
		//r2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("Finished the task");
	}

}
