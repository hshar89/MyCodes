package multithreading;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
class Task implements Runnable{
	private String name;
	public Task (String s){
		this.name = s;
	}
	public void run(){
	   	try{
	   		for(int i =0;i<5;i++){
	   			if(i==0){
	   				Date d1 = new Date();
	   				SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
	   				System.out.println("initialization time ---"+name+" = "+sdf1.format(d1));
	   			}else{
	   				Date d1 = new Date();
	   				SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
	   				System.out.println("Executing Time for task name - "+name+" = "+sdf1.format(d1));
	   			}
	   			Thread.sleep(1000);
	   		}
	   		System.out.println(name+" complete");
	   	}catch(InterruptedException e){
	   		System.out.println("exception: "+e.getStackTrace());
	   	}
	}
}
public class ThreadPoolGFG {
	 // Maximum number of threads in thread pool 
    static final int MAX_T = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(MAX_T);
        for(int i =0;i<5;i++){
        	Runnable Task = new Task("Pool "+i);
        	executor.execute(Task);//calling execute method of ExecutorService 
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   } 
        System.out.println("Finished all threads"); 
	}

}
