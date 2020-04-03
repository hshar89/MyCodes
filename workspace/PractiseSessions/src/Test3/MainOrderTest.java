package Test3;

public class MainOrderTest {

	public static void main(String[] args) {
		OrderTemplate net = new NetOrder(true);
		OrderTemplate shop = new ShopOrder(false);
		System.out.println("Puchasing online ------");
		net.purchaseItem();
		System.out.println("Purchasing through shop-----");
		shop.purchaseItem();

	}

}
