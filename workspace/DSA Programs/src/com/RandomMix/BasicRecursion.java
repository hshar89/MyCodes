package PractiseJavaPrograms;

public class BasicRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //printFromNto1(56);
        //System.out.println("factorial "+tailRecursiveForm(5,1));
		System.out.println("maximum peices "+getMaxPieces(23,9,11,12));
	}
	static void printFromNto1(int n){
		if(n<=0){
			return;
		}
		
	    printFromNto1(n-1);
	    System.out.print(n+" ");
	}
	static int factorial(int n){
		if(n==0 || n==1){
			return 1;
		}
		return n*factorial(n-1);
	}
	static int tailRecursiveForm(int n, int res){
		if(n==0 || n==1){
			return res;
		}
		return tailRecursiveForm(n-1,res*n);
	}
	static int getMaxPieces(int n, int a, int b, int c){
		if(n<0){
			return -1;
		}
		if(n==0){
			return 0;
		}
		System.out.println(" n "+n);
		int ca = getMaxPieces(n-a,a,b,c);
		System.out.println("ca "+ca);
		int cb = getMaxPieces(n-b,a,b,c);
		System.out.println("cb "+cb);
		int cc = getMaxPieces(n-c,a,b,c);
		System.out.println("cc "+cc);
		int res = Math.max(Math.max(ca, cb),cc);
		System.out.println("res "+res);
		if(res == -1){
			return -1;
		}else{
			return res+1;
		}
		
	}

}
