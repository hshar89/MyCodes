package Test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestingExecutorFramework {

	public static void main(String[] args) {
		ExecutorService service  = Executors.newCachedThreadPool();
		for(int i=0;i<100;i++) {
			service.submit(new Task(i));
		}

	}
static class Task implements Runnable{
	private int taskid;
	
	public Task(int id) {
		taskid = id;
	}
	@Override
	public void run() {
		System.out.println("Task Id: "+this.taskid+" performed BY "+Thread.currentThread().getName());
		
	}
	
	}
}
