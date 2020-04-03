package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {
	
	private static List<BasehealthCareCheckup> services;
	
	private static CountDownLatch latch;
	
	private ApplicationStartupUtil() {
		
	}
	private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
	
	public static ApplicationStartupUtil getInstance() {
		return INSTANCE;
	}
	
	public static boolean checkExternalServices() throws Exception{
		latch = new CountDownLatch(3);
		services = new ArrayList<>();
		services.add(new NetworkHealthChecker(latch));
		services.add(new DatabaseHealthChecker(latch));
		services.add(new CacheHealthChecker(latch));
		
		Executor executor = Executors.newFixedThreadPool(3);
		
		for(BasehealthCareCheckup service: services) {
			executor.execute(service);
		}
		latch.await();
		
		for(BasehealthCareCheckup service: services) {
			if(!service.isServiceUp()) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);

	}

}
