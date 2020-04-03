package Test1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockingThreadPoolExecutor extends ThreadPoolExecutor{
	
	private final Semaphore semaphore;
    
	public BlockingThreadPoolExecutor(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit units,	
										BlockingQueue<Runnable> bq) {
		super(corePoolSize, maxPoolSize, keepAliveTime, units, bq);
		semaphore = new Semaphore(corePoolSize+50);
	}
	@Override
	public void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}
	@Override
	public void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if(t!=null) {
			System.out.println(t.getMessage());
		}
		semaphore.release();
	}
	
	@Override
	public void execute(Runnable r) {
		boolean acquired = false;
		do {
			try {
				semaphore.acquire();
				acquired = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!acquired);
		try {
		super.execute(r);
		}catch(final RejectedExecutionException e) {
			System.out.println("Task Rejected");
			semaphore.release();
			throw e;
		}
	}
	
}
