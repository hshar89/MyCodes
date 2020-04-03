package Test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoExecutor {

	public static void main(String[] args) {
		
		Integer threadCount = 0;
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(60);
		CustomThreadPoolExecutor ctpe = new CustomThreadPoolExecutor(10,20,5000,TimeUnit.MILLISECONDS,bq);
		ctpe.setRejectedExecutionHandler(new RejectedExecutionHandler(){

			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("Demo task Rejected: "+((DemoTask)r).getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Lets add another time: "+((DemoTask)r).getName());
				ctpe.execute(r);
			}
			
		});
		ctpe.prestartAllCoreThreads();
		while(true) {
			threadCount++;
			ctpe.execute(new DemoTask(threadCount.toString()));
			if(threadCount==1000) {
				break;
			}
		}

	}

}
