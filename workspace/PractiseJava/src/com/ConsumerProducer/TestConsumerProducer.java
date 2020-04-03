package com.ConsumerProducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestConsumerProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(10);
		Consumer consumer = new Consumer(bq);
		Producer producer = new Producer(bq);
		Thread t1 = new Thread(consumer);
		Thread t2 = new Thread(producer);
		t1.start();
		t2.start();
		System.out.println("Producer Consumer started");
	}

}
