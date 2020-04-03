package multithreading;

public class RunnableInterface implements Runnable{
   public void run(){
	   System.out.println("Thread is running....");
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableInterface ri1 = new RunnableInterface();
		Thread t1 = new Thread(ri1);
		t1.start();
	}

}
