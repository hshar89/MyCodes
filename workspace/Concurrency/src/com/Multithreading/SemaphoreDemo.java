package com.Multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//This implementation is thread safe
enum Downloader{
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3,true);
	
	public void downloadDate() {
		try {
			semaphore.acquire();
			download();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}

	private void download() {
		System.out.println("Downloading data from the web");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class SemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ExecutorService es = Executors.newCachedThreadPool();
     for(int i=0;i<7;i++) {
    	 es.execute(new Runnable() {
    		 @Override
    		 public void run() {
    			 Downloader.INSTANCE.downloadDate(); 
    		 }
    	 });
     }
	}

}
