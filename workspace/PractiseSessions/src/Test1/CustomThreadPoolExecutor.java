package Test1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{
	
	public CustomThreadPoolExecutor(int corePoolSize, int maxPoolSize,long keepAliveTime,
									TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
	}
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if(t!=null) {
			t.printStackTrace();
		}
	}
}
