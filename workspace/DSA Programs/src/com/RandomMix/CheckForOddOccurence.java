package PractiseJavaPrograms;

import java.math.BigInteger;

public class CheckForOddOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr ={9, 12, 2, 11, 2, 2, 10, 9, 12, 10, 9, 11, 2};
     int x = arr[0];
     for(int i=1;i<arr.length;i++){
    	 x = x^arr[i];
     }
     System.out.println(1<<0);
     System.out.println(~5);
     int a = 2,b=3;
     System.out.println("a^ "+ (a^b));
     a^=b;
     System.out.println("a^=b "+a);
     b^=a;
     a^=b;
     System.out.println("a "+a+" b "+b);
     char ab = '1';
     System.out.println("num value "+(int)ab);
     System.out.println("gray to binary "+grayToBinary(4));
     BigInteger bigA = new BigInteger("1099511627776");
     System.out.println("is power of two "+isPowerofTwo(bigA));
     System.out.println("dropping 2 bits from 23 "+ (23>>2));
     System.out.println("a new one "+ (23&0xAAAAAAAA));
     System.out.println("a new one 2 "+ (23&0x55555555));
	}
	 public static boolean isPowerofTwo(BigInteger n){
	        
	        // Your code here
	        if(n.intValue()==0) return false;
	        BigInteger A = BigInteger.ONE;
	        System.out.println("big subtract 1 "+n.and(n.subtract(A)));
	        if((n.and(n.subtract(A))).intValue() == 0)return true;
	        
	        return false;
	        
	    }
public static int grayToBinary(int n) {
        
        // Your code here
        if(n==0||n==1)return n;
        String ab = "";
        String res ="";
        while(n>0){
            ab+=n%2;
            n=n/2;
        }
        int len = ab.length()-1,j=0;
        res+=ab.charAt(len);
        while(--len>=0){
            if(ab.charAt(len)=='0'){
                res+=res.charAt(j);
            }else{
                res+=flip(res.charAt(j));
            }
            j++;
        }
        System.out.println("res "+res);
        int num =0;
        len = res.length();
        int i = res.length();
        while(--i>=0){
            num+=Integer.parseInt(String.valueOf(res.charAt(i)))*
            Math.pow(2,len-i-1);
        }
        return num;
    }
    static String flip(char a){
        return a=='0'?"1":"0";
    }

}
