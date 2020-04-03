package com.MathsForProgramming;

public class FastExponentiation {
    private static final int M = 1000000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int n = 4;
     int m = 15;
     System.out.println("Iterative approach: "+calculatePower(n,m));
     System.out.println("recursive approach: "+calculatePowerRecursion(n,m));
     System.out.println("Modular Iterative approach: "+modularExponentiation(n,m));
	}

	private static int calculatePower(int n, int m) {
		// TODO Auto-generated method stub
		int result = 1;
		while(m>0) {
			//System.out.print("\nm: "+m+" ");
			if(m%2==1) {
				result = (result*n);
				//System.out.print("Result: "+result+" ");
			}
			n = (n*n);
			//System.out.print("n: "+n+" ");
			m=m/2;
		}
		return result;
	}
    private static long calculatePowerRecursion(int n, int m) {
    	if(m<=0) {
    		return 1;
    	}
    	if(m%2==0) {
    		return calculatePowerRecursion(n*n,m/2);
    	}
    	return n*calculatePowerRecursion(n*n,(m-1)/2);
    }
    private static long modularExponentiation(int x,int n)
    {
        if(n==0)
            return 1;
        else if(n%2 == 0)        //n is even
            return modularExponentiation((x*x)%M,n/2);
        else                             //n is odd
            return (x*modularExponentiation((x*x)%M,(n-1)/2))%M;

    }
}
