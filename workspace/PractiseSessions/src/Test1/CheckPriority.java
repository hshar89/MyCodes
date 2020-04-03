package Test1;

public class CheckPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Producer(),"Prod");
		Thread t2 = new Thread(new Consumer(),"Cons");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();

	}
	
	static class Producer implements Runnable{

		@Override
		public void run() {
			try {
				for(int i=0;i<10;i++) {
					System.out.println("Produced: "+i);
					Thread.yield();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	static class Consumer implements Runnable{

		@Override
		public void run() {
			try {
				for(int i=0;i<10;i++) {
					System.out.println("Consumed: "+i);
					Thread.yield();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}
