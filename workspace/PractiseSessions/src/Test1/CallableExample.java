package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor pool = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		List<Future<Integer>> futures = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<4;i++) {
			Integer num = random.nextInt(10);
			FactorialCalculator fc = new FactorialCalculator(num);
			Future<Integer> future = pool.submit(fc);
			futures.add(future);
		}
		for(Future<Integer> f: futures) {
			try {
				System.out.println("Future result is: "+"-"+f.get()+" and task is done "+f.isDone());
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		pool.shutdown();

	}

}
