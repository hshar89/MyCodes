package multithreading;

public class TestThreadPriority extends Thread{
    public void run(){
    	System.out.println("running thread name is:"+Thread.currentThread().getName());  
    	System.out.println("running thread priority is:"+Thread.currentThread().getPriority());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThreadPriority ttp1 = new TestThreadPriority();
		TestThreadPriority ttp2 = new TestThreadPriority();
		TestThreadPriority ttp3 = new TestThreadPriority();
		ttp3.setName("Thread 3");
		ttp1.setName("Thread 1");
		ttp2.setName("Thread 2");
		ttp3.setPriority(Thread.NORM_PRIORITY);
		ttp1.setPriority(Thread.MIN_PRIORITY);
		ttp2.setPriority(Thread.MAX_PRIORITY);
		ttp3.start();
		ttp1.start();
		ttp2.start();
	}

}
