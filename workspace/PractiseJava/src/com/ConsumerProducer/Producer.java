package com.ConsumerProducer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
private BlockingQueue<String> blockingQueue;
	
	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			String msg = "Producing: ";
			for(int i=0;i<20;i++) {
				Thread.sleep(i);
				blockingQueue.put(msg+i);
				System.out.println("Produced i:"+i);
			}
			msg = "Exit";
			blockingQueue.put(msg);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
