package multithreading;

public class SleepInJava extends Thread{
public void run(){
	for(int i=0;i<5;i++){
		/*try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			System.out.println("caught exp "+e.getMessage());
		}*/
		System.out.println("i value "+i);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SleepInJava sj1 = new SleepInJava();
    SleepInJava sj2 = new SleepInJava();
    sj1.start();
    sj2.start();
	}
	
}
