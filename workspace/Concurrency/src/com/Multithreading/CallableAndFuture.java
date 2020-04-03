package com.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class processor3 implements Callable<String> {
	private int id;

	public processor3(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);

		return ("id: " + id);
	}
}

public class CallableAndFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ExecutorService es = Executors.newFixedThreadPool(3);
     List<Future<String>> futures = new ArrayList<>();
     
     for(int i=0;i<5;i++) {
    	 Future<String> future = es.submit(new processor3(i+1));
    	 futures.add(future);
     }
     
     for(Future<String> future: futures) {
    	 try {
    	 System.out.println(future.get());
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     es.shutdown();
	}

}
