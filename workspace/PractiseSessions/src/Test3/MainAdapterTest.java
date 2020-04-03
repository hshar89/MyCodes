package Test3;

public class MainAdapterTest {

	public static void main(String[] args) {
		
		Bird bird = new Sparrow();
		ToyDuck plastic = new PlasticToyDuck();
		BirdAdapter ba = new BirdAdapter(bird);
		
		System.out.println("Sparrow can do this...");
		bird.fly();
		bird.sound();
		
		System.out.println("ToyDuck can do this...");
		plastic.squeak();
		
		System.out.println("Toyduck as a bird can do this...");
		ba.squeak();
	}

}
