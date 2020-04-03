package com.Multithreading;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class worker5 implements Runnable{
	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;
	
	public worker5(int id,CyclicBarrier cyclicBarrier,Random random) {
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
		this.random = random;
	}
    public void doWork() {
    	System.out.println("Thread with ID "+id+" starts the task...");
    	
    	try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Thread with ID "+id+" finished...");
    	
    	try {
			cyclicBarrier.await();
			System.out.println("After Await....");
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public String toString() {
    	return ""+this.id;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doWork();
		
	}
}
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ExecutorService es = Executors.newFixedThreadPool(7);
     CyclicBarrier barrier = new CyclicBarrier(7,new Runnable() {
    	 @Override
    	 public void run() {
    		 System.out.println("All tasks are complete...");
    	 }
     });
     
     for(int i=0;i<7;i++) {
    	 es.execute(new worker5(i+1,barrier,new Random()));
     }
     es.shutdown();
	}

}
