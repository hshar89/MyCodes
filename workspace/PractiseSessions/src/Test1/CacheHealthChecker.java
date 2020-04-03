package Test1;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BasehealthCareCheckup {

	public CacheHealthChecker(CountDownLatch latch) {
		super("Cache Health Checker", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("checking "+this.getServiceName());
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName()+" is up");

	}

}
