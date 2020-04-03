package Test3;

public abstract class OrderTemplate {
	public boolean gift;
	public abstract void select();
	public abstract void payment();
	public abstract void delivery();
	public abstract void giftWrap();
	final void purchaseItem() {
		select();
		payment();
		if(gift) {
			giftWrap();
		}
		delivery();
	}
}
