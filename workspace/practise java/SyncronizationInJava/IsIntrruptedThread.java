package SyncronizationInJava;

public class IsIntrruptedThread extends Thread {
     public void run(){
    	 for(int i=0;i<3;i++){
    		 if(Thread.interrupted()){
    			 System.out.println("intrrupted thread");
    		 }else{
    			 System.out.println("Normal thread");
    		 }
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsIntrruptedThread iit1 = new IsIntrruptedThread();
		IsIntrruptedThread iit2 = new IsIntrruptedThread();
		iit1.start();
		iit1.interrupt();
		iit2.start();
	}

}
