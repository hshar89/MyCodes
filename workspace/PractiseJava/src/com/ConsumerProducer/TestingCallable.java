package com.ConsumerProducer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingCallable implements Callable{
	
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<Future<String>> results = new ArrayList<>();
		Callable<String> callable = new TestingCallable();
		for(int i=0;i<100;i++) {
			Future<String> future = es.submit(callable);
			results.add(future);
		}
		for(Future<String> f: results) {
			try {
				System.out.println(new Date()+"::"+f.get());
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		es.shutdown();
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(500);
		//System.out.println("Ran callable");
		return Thread.currentThread().getName();
	}

}
