package multithreading;
class MyThread extends Thread{
	public void run(){
		System.out.println("Running current thread"+Thread.currentThread().getName());
	}
}
public class ShutDownHook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Runtime r = Runtime.getRuntime();
      r.addShutdownHook(new MyThread());
      System.out.println("Now main sleeping... press ctrl+c to exit"); 
      try{
    	  Thread.sleep(3000);
    	  }catch (Exception e) {
    		  System.out.println(e.getMessage());
    	  }  
	}  
	}
