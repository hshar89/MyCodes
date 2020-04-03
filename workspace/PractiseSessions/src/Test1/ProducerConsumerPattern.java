package Test1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

	public static void main(String[] args) {
		
		BlockingQueue sharedQueue = new LinkedBlockingQueue();
		
		ExecutorService prodPool = Executors.newFixedThreadPool(10);
		
		ExecutorService consPool = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<10;i++) {
			prodPool.submit(new Producer(sharedQueue,i*10));
			consPool.submit(new Consumer(sharedQueue));
		}
		//Thread prodThread = new Thread(new Producer(sharedQueue));
		
		//Thread consThread = new Thread(new Consumer(sharedQueue));
		
		//prodThread.start();
		//consThread.start();

	}
static class Producer implements Runnable{

	private final BlockingQueue bq;
	
	private int index;
	
	public Producer(BlockingQueue bq, int index) {
		this.bq = bq;
		this.index = index;
	}
	public void run() {
		
		for(int i=index;i<(10+index);i++) {
			try {
				System.out.println("Produced :"+i);
				bq.put(i);
				
			}catch(InterruptedException e) {
				System.out.println(Producer.class.getName()+" "+e.getMessage());
			}
		}
		
	}
	
}
static class Consumer implements Runnable{

	private final BlockingQueue bq;
	
	public Consumer(BlockingQueue bq) {
		this.bq = bq;
	}
	public void run() {
	 
		while(true) {
			try {
				System.out.println("Consumed: "+bq.take());
				
			}catch(InterruptedException e) {
				System.out.println(Consumer.class.getName()+" "+e.getMessage());
			}
			
		}
		
	}
	
}

}
