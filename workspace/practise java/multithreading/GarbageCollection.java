package multithreading;

public class GarbageCollection {
public void finalize(){
	System.out.println("object is garbage collected");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GarbageCollection gc1 = new GarbageCollection();
		GarbageCollection g2 = new GarbageCollection();
		gc1 = g2;
		System.gc();
	}

}
