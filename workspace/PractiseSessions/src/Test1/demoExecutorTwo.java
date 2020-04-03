package Test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class demoExecutorTwo {

	public static void main(String[] args) {
		Integer threadCounter = 0;
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(50);
		BlockingThreadPoolExecutor btpe = new BlockingThreadPoolExecutor(10,20,5000,TimeUnit.MILLISECONDS,bq);
		btpe.setRejectedExecutionHandler(new RejectedExecutionHandler() {

			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				
				System.out.println("DemoTask Rejected: "+((DemoTask)r).getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("lets add another time: "+((DemoTask)r).getName());
				btpe.execute(r);
				
			}
			
		});
		btpe.prestartAllCoreThreads();
		while(true) {
			threadCounter++;
			System.out.println("Adding DemoTask: "+threadCounter);
			btpe.execute(new DemoTask(threadCounter.toString()));
			if(threadCounter == 1000) {
				break;
			}
			
		}

	}

}
