package multithreading;
public class WorkerThread implements Runnable{
      private String msg;
      public WorkerThread(String s){
    	  this.msg = s;
      }
     private void processMessage(){
    	 try{
    		 Thread.sleep(2000);
    	 }catch(InterruptedException e){
    		 System.out.println(e.getMessage());
    	 }
     }
     public void run(){
    	 System.out.println(Thread.currentThread().getName()+" (Start) message = "+msg);
    	 processMessage();
    	 System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name 
     }
}
