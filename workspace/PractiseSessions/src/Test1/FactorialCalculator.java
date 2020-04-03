package Test1;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {
	
	private int number;
	
	public FactorialCalculator(int num) {
		number = num;
	}
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(number == 0 || number == 1) {
			result = 1;
		}else {
		
		for(int i=1;i<=number;i++) {
			result*=i;
		}
		}
		System.out.println("The result for number :"+number+" is "+result);
		return result;
	}

}
