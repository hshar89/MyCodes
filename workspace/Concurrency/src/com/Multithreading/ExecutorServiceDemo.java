package com.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class worker3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class ExecutorServiceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ExecutorService es = Executors.newCachedThreadPool();//Executors.newSingleThreadExecutor();//Executors.newFixedThreadPool(5);
      
      for(int i=0;i<5;i++) {
    	 es.submit(new worker3());
      }
	}

}
