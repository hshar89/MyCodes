package multithreading;

public class Multi extends Thread{
public void run(){
	System.out.println("thread is running");
}
	public static void main(String[] args) {
		Multi m1 = new Multi();
		m1.start();
		// TODO Auto-generated method stub

	}

}
