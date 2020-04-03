package PractiseJavaPrograms;

public class Factorial {
	public int prod = 1;
    static int getFactorial(int num){
    	if(num==1){
    		return 1;
    	}else{
    		return (num*getFactorial(num-1));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.print("factorial "+Factorial.getFactorial(7));
	}

}
