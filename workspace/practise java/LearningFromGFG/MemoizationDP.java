package LearningFromGFG;

public class MemoizationDP {
	final int MAX=100;
	final int min=-1;
	int[] lookup = new int[MAX];
	void _initialize(){
		for(int i=0;i<lookup.length;i++){
			lookup[i] = min;
		}
	}
    public int fib(int n){
    	if(lookup[n]==min){
    		if(n<=1){
    			lookup[n] = n;
    		}else{
    			lookup[n] = fib(n-1)+fib(n-2);
    		}
    	}
    	return lookup[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		MemoizationDP mdp = new MemoizationDP();
		mdp._initialize();
		System.out.println("Fibonacci number is" + " " + mdp.fib(n)); 
	}

}
