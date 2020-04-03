package Test1;

import java.util.List;

public class ProducerCPP implements Runnable{

	private final List<Integer> taskQueue;
	private final int MAX_CAPACITY;
	
	public ProducerCPP(List<Integer> taskQueue, int capacity) {
		this.taskQueue = taskQueue;
		this.MAX_CAPACITY = capacity;
	}
	
	@Override
	public void run() {
		int counter = 0;
		while(true) {
			try {
				produce(counter++);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	public void produce(int i)throws InterruptedException{
		synchronized(taskQueue){
			while(taskQueue.size()==MAX_CAPACITY) {
				System.out.println("Queue is full "+Thread.currentThread().getName()+" is waiting, size: "+taskQueue.size());
				taskQueue.wait();
			}
			Thread.sleep(100);
			taskQueue.add(i);
			System.out.println("Produced "+i);
			taskQueue.notifyAll();
		}
	}

}
