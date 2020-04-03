package SyncronizationInJava;

public class TestDeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     final String str1 = "Jaynat bansiwal";
     final String str2 = "Monika Darling";
     Thread t1 = new Thread(){
    	 public void run(){
    		 synchronized (str1){
    			 System.out.println("Thread 1: locked resourse 1");
    			 try{
    				 Thread.sleep(100);
    			 }catch(Exception e){}
    			 synchronized (str2){
    				 System.out.println("Thread 1: locked resource 2");
    			 }
    		 }
    		 
    	 }
     };
     Thread t2 = new Thread(){
    	 public void run(){
    		 synchronized(str2){
    			 System.out.println("Thread 2: locked resource 2"); 
    			 try { Thread.sleep(100);} catch (Exception e) {}
    			 synchronized (str1) {  
    		            System.out.println("Thread 2: locked resource 1");  
    		          }  
    		 }
    	 }
     };
     t1.start();
     t2.start();
	}

}
