package Test3;

import java.util.List;

public class Consumer implements Runnable{
	
	private List<Integer> shared;
	private final int size;
	public Consumer(List<Integer> shared, int size) {
		this.shared = shared;
		this.size = size;
	}
	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println("Consumed "+consume());
				Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private int consume() throws InterruptedException {
		while(shared.isEmpty()) {
			synchronized(shared) {
				System.out.println("Queue is empty "+" Consumer waiting "+ shared.size());
				shared.wait();
			}
		}
		synchronized(shared) {
			shared.notifyAll();
			return (int)shared.remove(0);
		}
	}

}
