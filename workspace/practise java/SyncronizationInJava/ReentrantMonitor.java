package SyncronizationInJava;

public class ReentrantMonitor extends Thread {
     synchronized public void m(){
    	 System.out.println("this is m");
    	 n();
     }
     synchronized public void n(){
    	 System.out.println("this is n");
     }
     public void run(){
    	 m();
    	 n();
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantMonitor rm1 = new ReentrantMonitor();
		rm1.start();
	}

}
