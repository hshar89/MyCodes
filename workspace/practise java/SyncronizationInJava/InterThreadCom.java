package SyncronizationInJava;
class Consumer{
	public int amount=10000;
	synchronized void withraw(int amount){
	if(this.amount<amount){
		System.out.println("Less balance; waiting for deposit...");  
		try{
			wait();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		this.amount-=amount;
		System.out.println("withraw complete...");
	}
	}
	synchronized void deposit(int amount){
		System.out.println("going to deposit..."); 
		this.amount += amount;
		System.out.println("deposit completed... ");  
		notify();  
	}
}
public class InterThreadCom extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           final Consumer c1 = new Consumer();
           Thread t1 = new Thread(){
        	   public void run(){
        		   c1.withraw(12000);
        	   }
           };
           Thread t2 = new Thread(){
        	 public void run(){
        		 c1.deposit(5000);
        	 }
           };
           t1.start();
           t2.start();
	}

}
