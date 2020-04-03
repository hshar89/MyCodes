package Test1;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BasehealthCareCheckup {

	public DatabaseHealthChecker(CountDownLatch latch) {
		super("Database Health Checker", latch);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verifyService() {
		System.out.println("checking "+this.getServiceName());
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName()+" is up");

	}

}
