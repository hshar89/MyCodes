package PractiseJavaPrograms;

public class FibonacciSeries {
	static int a=0,b=1,c;
    static void getFibonacci(int num){
    	if(num>0){
    		c = a+b;
    		System.out.print("\n"+c);
    		a=b;
    		b=c;
    		getFibonacci(num-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(0+"\n"+1);
     FibonacciSeries.getFibonacci(8);
	}

}
