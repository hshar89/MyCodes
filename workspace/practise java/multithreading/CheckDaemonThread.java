package multithreading;

public class CheckDaemonThread extends Thread{
    public void run(){
    	if(Thread.currentThread().isDaemon()){
    		System.out.println("Daemon thread working");
    	}else{
    		System.out.println("User thread working");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckDaemonThread cdt1 = new CheckDaemonThread();
		CheckDaemonThread cdt2 = new CheckDaemonThread();
		CheckDaemonThread cdt3 = new CheckDaemonThread();
		cdt1.setDaemon(true);
		cdt1.start();
		cdt2.start();
		cdt3.start();
	}

}
