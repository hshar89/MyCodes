package Test1;

import java.util.ArrayList;
import java.util.List;

public class ProdConsTest {

	public static void main(String[] args) {
		
		List<Integer> taskQueue =new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread tProducer = new Thread(new ProducerCPP(taskQueue,MAX_CAPACITY),"Producer");
		Thread tConsumer = new Thread(new ConsumerCPP(taskQueue),"Consumer");
		
		tProducer.start();
		tConsumer.start();
		

	}

}
