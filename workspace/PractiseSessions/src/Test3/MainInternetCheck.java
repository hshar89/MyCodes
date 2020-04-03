package Test3;

public class MainInternetCheck {

	public static void main(String[] args) {
		Internet net = new ProxyInternet();
		try {
			net.connect("google.com");
			net.connect("someporn.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}

	}

}
