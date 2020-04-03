package multithreading;

public class CurrentThread extends Thread{
    public void run(){
    	System.out.println("thread name "+Thread.currentThread().getName());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentThread ct1 = new CurrentThread();
		CurrentThread ct2 = new CurrentThread();
        ct1.start();
        ct2.start();
	}

}
