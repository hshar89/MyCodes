package Test1;

import java.util.List;

public class ConsumerCPP implements Runnable{
	private final List<Integer> taskQueue;
	
	public ConsumerCPP(List<Integer> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
			consume();
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void consume() throws InterruptedException{
		synchronized(taskQueue) {
			while(taskQueue.size()==0) {
				System.out.println("task queue is empty() "+Thread.currentThread().getName()+" is wating "+taskQueue.size());
				taskQueue.wait();
			}
			Thread.sleep(1000);
			int i = (Integer)taskQueue.remove(0);
			System.out.println("Consumed "+i);
			taskQueue.notifyAll();
		}
	}

}
