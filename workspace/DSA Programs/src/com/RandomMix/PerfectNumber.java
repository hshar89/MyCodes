package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 findAllFactors(48492482942l);
	}
	static void findAllFactors(long num){
	     long sum = 1l;
	    
	     for(long i=2l;i*i<=num;i++){	        
	         if(num%i ==0){
	            sum=sum+i+num/i; 
	         }
	     }
	  
	     if(sum == num){
	         System.out.println(1);
	     }else{
	         System.out.println(0);
	     }
	 }
}
