package SyncronizationInJava;
class Table2{
	 synchronized public void print(int n){
		for(int i=0;i<10;i++){
			System.out.println(n*i);
			try{
				Thread.sleep(400);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}

public class WithSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        final Table2 t1 = new Table2();
        final Table2 t2 = new Table2();
        Thread thread1 = new Thread(){
        	public void run(){
        		t1.print(5);
        	}
        };
        Thread thread2 = new Thread(){
        	public void run(){
        		t1.print(100);
        	}
        };
        Thread thread3 = new Thread(){
        	public void run(){
        		t2.print(500);
        	}
        };
        Thread thread4 = new Thread(){
        	public void run(){
        		t2.print(1000);
        	}
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
	}

}
