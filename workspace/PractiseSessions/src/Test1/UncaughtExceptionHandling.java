package Test1;

public class UncaughtExceptionHandling {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task(),"test1");
		t1.start();

	}
	
	static class Task implements Runnable{

		@Override
		public void run() {
			Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
			System.out.println(Integer.parseInt("123"));
			System.out.println(Integer.parseInt("451"));
			System.out.println(Integer.parseInt("abc"));
			System.out.println(Integer.parseInt("897"));
		}
		
	}
	static class ExceptionHandler implements Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("An exception has been captured\n");
		      System.out.printf("Thread: %s\n", t.getName());
		      System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		      System.out.printf("Stack Trace: \n");
		      e.printStackTrace(System.out);
		      System.out.printf("Thread status: %s\n", t.getState());
		      new Thread(new Task(),"Test2").start();
			
		}
		
	}

}
