package SyncronizationInJava;

public class IntruptJava extends Thread{
 public void run(){
	 try{
		 Thread.sleep(1000);
		 System.out.println("Taks");
	 }catch(InterruptedException e){
		 throw new RuntimeException("thread intrrupted...."+e.getStackTrace());
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntruptJava ij1 = new IntruptJava();
		ij1.start();
		try{
			ij1.interrupt();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
