package Test3;

public class RealInternet implements Internet {

	@Override
	public void connect(String host) {
		System.out.println("Connecting you to the url "+host);

	}

}
