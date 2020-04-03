package Test1;

public class SynchronizedMethodsExp {

	public static void main(String[] args) {
		MathClass mc = new MathClass();
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				try {
					mc.printNumbers(3);
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		};
		
		Thread t1 = new Thread(r1,"test1");
		Thread t2 = new Thread(r1,"test2");
		t1.start();
		t2.start();

	}
static class MathClass{
	void printNumbers(int n)throws InterruptedException{
		synchronized(this) {
			for(int i=0;i<=n;i++) {
				System.out.println(Thread.currentThread().getName()+" "+i);
				Thread.sleep(500);
			}
		}
	}
}
}
