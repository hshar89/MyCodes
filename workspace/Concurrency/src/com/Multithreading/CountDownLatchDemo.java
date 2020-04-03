package com.Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class worker4 implements Runnable{
	private int id;
	private CountDownLatch countDownLatch;
	public worker4(int id, CountDownLatch countDownLatch) {
		this.id= id;
		this.countDownLatch = countDownLatch;
	}
	@Override
	public void run() {
		doWork();
		countDownLatch.countDown();
	}
	private void doWork() {
		System.out.println("Thread with id: "+this.id+ " starts working...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class CountDownLatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ExecutorService es = Executors.newFixedThreadPool(3);//Executors.newSingleThreadExecutor();
        //The number in the latch defines how many tasks will be completed before the main thread
        //takes over. If you increment the counter to more than the number of tasks
        //the main method will wait forever
        CountDownLatch latch = new CountDownLatch(5);
        for(int i=0;i<5;i++) {
        	es.execute(new worker4(i,latch));
        }
        
        try {
        	latch.await();
        }catch(InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("All the prerequisites are done....");
	}

}
