package com.Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class firstWorker implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    public firstWorker(BlockingQueue<Integer> blockingQueue) {
    	this.blockingQueue = blockingQueue;
    }
	@Override
	public void run() {
		int counter=0;
		while(true) {
			try {
				blockingQueue.put(counter);
				System.out.println("Putting item to the queue..."+counter);
			     counter++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class SecondWorker implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
    	this.blockingQueue = blockingQueue;
    }
	@Override
	public void run() {
		while(true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Taking item from the queue..."+number);
				//If this thread is faster than putting the item thread then
				//it will have to wait before items are added to the queue
				//So the printing will be in sync
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
public class BlockingQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
     
     firstWorker firstworker = new firstWorker(blockingQueue);
     SecondWorker secondworker = new SecondWorker(blockingQueue);
     new Thread(firstworker).start();
     new Thread(secondworker).start();
     
     System.out.println("Done...");
	}

}
