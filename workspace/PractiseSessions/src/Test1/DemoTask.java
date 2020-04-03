package Test1;

public class DemoTask implements Runnable{

	private String name = null;
	public DemoTask(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Executing: "+name);
		
	}
	

}
