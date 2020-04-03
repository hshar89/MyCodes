package com.ConsumerProducer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<String> blockingQueue;
	
	public Consumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		
		try {
			String msg;
			while(!(msg = blockingQueue.take()).equals("Exit")){
				Thread.sleep(100);
				System.out.println("Consumer Consumed "+msg);
			}
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Consumer is done!!!");
	}

}
