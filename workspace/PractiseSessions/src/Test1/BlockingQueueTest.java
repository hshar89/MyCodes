package Test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(2);
		bq.put(12);
		System.out.println("adding 12");
		bq.put(11);
		System.out.println("adding 11");
		bq.take();
		if(bq.offer(14)) {
			System.out.println("added succesfully");
		}
		bq.take();
		bq.put(14);
		System.out.println("Adding 14");

	}

}
