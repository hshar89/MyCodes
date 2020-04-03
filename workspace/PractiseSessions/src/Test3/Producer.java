package Test3;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{
	
	public List<Integer> sharedResource;
	private final int size;
	boolean consumerReady = false;
	public Producer(List<Integer> shared, int size) {
		this.sharedResource = shared;
		this.size =size;
	}
	@Override
	public void run() {
		
		try {
			for(int i=0;i<7;i++) {
				System.out.println("Produced "+i);
				produce(i);
			}
			consumerReady = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private void produce(int i) throws InterruptedException {
		while(sharedResource.size()==size) {
			synchronized(sharedResource) {
				System.out.println("Queue is full "+
			Thread.currentThread().getName()+" is wating "+sharedResource.size());
				sharedResource.wait();
			}
		}
		synchronized(sharedResource) {
			sharedResource.add(i);
			sharedResource.notifyAll();
		}
	}

}
