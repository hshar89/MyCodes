package SyncronizationInJava;
class Table{
	 public void print(int n){
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
class MyThread1 extends Thread{
	Table t;
	public MyThread1(Table t){
		this.t = t;
	}
	public void run(){
		t.print(5);
	}
}
class Mythread2 extends Thread{
	Table t;
	 public Mythread2(Table t){
		 this.t = t;
	 }
	 public void run(){
		 t.print(100);
	 }
}
public class WithoutSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Table t1 = new Table();
        MyThread1 mt1 = new MyThread1(t1);
        Mythread2 mt2 = new Mythread2(t1);
        mt1.start();
        mt2.start();
	}

}
