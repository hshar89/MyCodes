package Test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet{
	
	private Internet internet = new RealInternet();
	private List<String> bannedSites;
	public ProxyInternet() {
		bannedSites = new ArrayList<String>(Arrays.asList("hbo.com","cartoon.com","grayhouse.com","someporn.com"));
	}
	@Override
	public void connect(String host) throws Exception {
		if(bannedSites.contains(host)) {
			throw new Exception("Access Denied");
		}
		internet.connect(host);
	}

}
