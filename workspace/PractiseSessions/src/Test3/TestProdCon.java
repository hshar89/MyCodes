package Test3;

import java.util.ArrayList;
import java.util.List;

public class TestProdCon {

	public static void main(String[] args) {
		List<Integer> shared = new ArrayList<>();
		Producer prod = new Producer(shared,4);
		Consumer cons = new Consumer(shared,4);
		Thread t1 = new Thread(prod,"Producer");
		Thread t2 = new Thread(cons,"Consumer");
		t1.start();
		t2.start();
	}

}
