package multithreading;

public class JoinInThread extends Thread{
  public void run(){
	  for(int i=0;i<5;i++){
		  try{
			  Thread.sleep(500);
		  }catch(InterruptedException e){
			  System.out.println("caught interupted exception "+e.getMessage());
		  }
		  System.out.println(i);  
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinInThread j1 = new JoinInThread();
		JoinInThread j2 = new JoinInThread();
		JoinInThread j3 = new JoinInThread();
		j1.start();
		try{
			j1.join();
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("thread name:"+j1.getName()+" id "+j1.getId());
		j2.start();
		try{
			j2.join();
		}catch(Exception e){
			System.out.println(e);
		}
		j3.start();
	}

}
