package Test3;

public class NetOrder extends OrderTemplate {
	
	public NetOrder(boolean gift) {
		this.gift = gift;
	}
	@Override
	public void select() {
		System.out.println("Selecting item online");
	}

	@Override
	public void payment() {
		System.out.println("Paying for the item");

	}

	@Override
	public void delivery() {
		System.out.println("The item will be delivered in 2 days");

	}

	@Override
	public void giftWrap() {
		System.out.println("Your item will be gift wrapped");

	}

}
