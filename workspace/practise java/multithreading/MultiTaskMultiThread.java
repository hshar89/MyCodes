package multithreading;

public class MultiTaskMultiThread extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread t1 = new Thread(){
        	public void run(){
        		System.out.print("Type 1");
        	}
        };
        Thread t2 = new Thread(){
        	public void run(){
        		System.out.println("Type 2");
        	}
        };
        t1.start();
        t2.start();
	}

}
