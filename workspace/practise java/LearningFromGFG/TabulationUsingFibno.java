package LearningFromGFG;

public class TabulationUsingFibno {
   public int fib(int n){
	   int[] f = new int[n+1];
	   f[0] = 0;
	   f[1] = 1;
	   for(int i=2;i<=n;i++){
		   f[i] = f[i-1]+f[i-2];
	   }
	   return f[n];
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TabulationUsingFibno f = new TabulationUsingFibno(); 
	    int n = 40; 
	    long d1 = System.currentTimeMillis();
	    System.out.println("Fibonacci number is" + " " + f.fib(n));
	    System.out.println("time taken "+(System.currentTimeMillis() - d1));
	}

}
