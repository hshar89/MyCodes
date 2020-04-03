package Test3;

public class ShopOrder extends OrderTemplate {
	
	public ShopOrder(boolean gift) {
		this.gift = gift;
	}
	@Override
	public void select() {
		System.out.println("Selecting item from the shelf");

	}

	@Override
	public void payment() {
		System.out.println("Paying through cash/card");

	}

	@Override
	public void delivery() {
		System.out.println("Please take the item with you");

	}

	@Override
	public void giftWrap() {
		System.out.println("Choose the wrapper for the gift");

	}

}
