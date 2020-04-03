package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeUptoGivenNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPrimeMethod2(6587688);
	}
	static void findPrimesUptoNumber(int num){
	     List<Integer> prime = new ArrayList<Integer>();
	     List<Integer> notPrime = new ArrayList<Integer>();
	     for(int i=2;i<=num;i++){	        
	         if(notPrime.contains(i)){
	        	 continue;
	         }
	         int j=2;
	        while(j<Math.sqrt(i)){
	            if(i%j == 0 && !notPrime.contains(i)){
	                notPrime.add(i); 
	            }
	            j++;
	        }
	        if(!notPrime.contains(i)){
	        	prime.add(i);
	        }
	     }
	     //System.out.println("these re not prime ");
	     //notPrime.forEach(n -> System.out.print(n+" "));
	     System.out.println("These are prime ");
	     prime.forEach((x) -> System.out.print(x+" "));
	 }
	static void findPrimeMethod2(int n){
		System.out.println("came to find");
		 boolean prime[] = new boolean[n+1]; 
	        for(int i=0;i<n;i++) 
	            prime[i] = true; 
	          
	        for(int p = 2; p*p <=n; p++) 
	        { 
	            // If prime[p] is not changed, then it is a prime 
	            if(prime[p] == true) 
	            { 
	                // Update all multiples of p 
	                for(int i = p*p; i <= n; i += p) 
	                    prime[i] = false; 
	            } 
	        } 
	          
	        // Print all prime numbers 
	        for(int i = 2; i <= n; i++) 
	        { 
	            if(prime[i] == true) 
	                System.out.print(i + " "); 
	        } 
	}
}
