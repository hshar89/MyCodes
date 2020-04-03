package Test1;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BasehealthCareCheckup{

	public NetworkHealthChecker(CountDownLatch latch) {
		super("Network Service", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("checking "+this.getServiceName());
		try {
			Thread.sleep(7000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName()+" is up");
	}

}
