package Test1;

import java.util.concurrent.CountDownLatch;

public abstract class BasehealthCareCheckup implements Runnable{
	
	private CountDownLatch latch;
	private String serviceName;
	private boolean serviceup;
	
	public BasehealthCareCheckup(String serviceName, CountDownLatch latch) {
		super();
		this.latch = latch;
		this.serviceName = serviceName;
		this.serviceup = false;
	}
	
	@Override
	public void run() {
		try {
			verifyService();
			serviceup = true;
		}catch(Throwable t) {
			t.printStackTrace();
			serviceup = false;
		}finally {
			if(latch!=null) {
				latch.countDown();
			}
		}
	}
	public String getServiceName() {
		return serviceName;
	}
	public boolean isServiceUp() {
		return serviceup;
	}
	public abstract void verifyService();
	
}
