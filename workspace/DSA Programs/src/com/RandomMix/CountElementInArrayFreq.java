package PractiseJavaPrograms;

import java.util.HashMap;
import java.util.Map;

public class CountElementInArrayFreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ab = "3 1 2 2 1 2 3 3";
		ab="1 3 3";
	     String[] abA = ab.split("\\s+");
	     int[] arr = new int[abA.length];
	     for(int i=0;i<abA.length;i++){
	    	 arr[i] = Integer.parseInt(abA[i]);
	     }
	     //int k =2;
	     //System.out.println("occurence more than n/k "+countOccurence(arr,abA.length,k));
	/*System.out.print("func "+fun(5));
	getf(6);
	System.out.print("aa "+foo(513,2));
	System.out.println("out "+f(1.73));
	f2(173);*/
	findNearest(1000000l);
	     //findMissing(arr,arr.length); 
	     int n = 47;
	     System.out.println("return min steps by GFG "+countways(n));
	}
	static void findNumberOfsteps(int n,int count){
	     if(n==1){
	         System.out.println(count);
	         return;
	     }
	      if(n%2==0){
	         n = n/2;
	      }else{
	          if(((n-1) & n-2) == 0){
	              n--;
	          }else if(((n+1) & n) == 0){
	              n++;
	          }else{
	              n--;
	          }
	      }
	     findNumberOfsteps(n,count+1);
	 }
	/*
	 * To Count number of steps required to reduce N to 1.
	 */
	static int countways(int n) 
	{  
   	    if (n == 1) 
	        return 0; 
	    else if (n % 2 == 0) 
	        return 1 + countways(n / 2); 
	    else
	        return 1 + Math.min(countways(n - 1), 
	                            countways(n + 1)); 
	} 
	  
	static void findNearest(long n){
	    long i=0;
	    while(i*i<n){
	        i++;
	    }
	    //System.out.println("i "+i);
	    long j = i-1;	    
	    if(i*i == n){
	    	i++;	    	
	    }
	    long d1 = j*j;
	    long d2 = i*i;
	    
	   // System.out.println("d1 "+d1+" d2 "+d2);
	    if(n-d1 < d2-n){
	        System.out.print(d1);
	    }else if(d2-n<=n-d1){
	        System.out.println(d2);
	    }
	 }
	static void findMissing(int[] arr, int n){
	      String ab="";
	     int[] arr2 = new int[n];
	     for(int i=0;i<n;i++){
	         arr2[arr[i]-1]++;
	         if(arr2[arr[i]-1] >1){
	             ab+=arr[i]+" ";
	         }
	     }
	    
	     for(int i=0;i<n;i++){
	         if(arr2[i]==0){
	           ab+=(i+1);  
	         }
	     }
	     System.out.println(ab);
	 }
	 static boolean checkPerfect(long n){
	     if(Math.sqrt(n)-Math.floor(Math.sqrt(n)) != 0){
	         return false;
	     }
	     return true;
	 }
	 static void findNearest2(long n){
	     if(checkPerfect(n)){
	         long a = n-1;
	         while(true){
	             if(checkPerfect(a)){
	                 break;
	             }else{
	                 a=a-1l;
	             }
	         }
	         System.out.println(a);
	     }else{
	      long a = n-1,b=n+1;
	      while(true){
	          if(checkPerfect(a)){
	              break;
	          }else{
	              a--;
	          }
	      }
	      
	      while(true){
	          if(checkPerfect(b)){
	              break;
	          }else{
	              b++;
	          }
	      }
	    if(n-a < b-n){
	        System.out.println(a);
	    }else{
	        System.out.println(b);
	    }
	 }
	 }
	static void f2(int n){
		if(n<=1){
			System.out.print(n);
		}else{
			f2(n/2);
			System.out.print(n%2);
		}
	}
	static double f(double x){
		if(Math.abs(x*x-3.0d)<0.01d){
			return x;
		}else{
			return f(x/2.0d + 1.5d/x);
		}
	}
	static int foo(int n,int r){
		if(n>0){
			return ((n%r)+foo(n/r,r));
			
		}else{
			return 0;
		}
		
	}
	static void getf(int n){
		System.out.println("called ");
		if(n<1) return;
		getf(n-1);
		getf(n-3);
		//System.out.println(" times "+n);
	}
	static int fun(int n){
		int x=1,k;
		if(n==1)return x;
		for(k=1;k<n;++k){
			x = x+fun(k)*fun(n-k);
		}
		return x;
	}
	 public static int countOccurence(int[] arr, int n, int k)
	    {
	        //your code here,return the answer
	        int numOfOcc = n/k, count=0;
	        Map<Integer,Integer> mp = new HashMap<>();
	        for(int i=0;i<n;i++){
	            if(mp.containsKey(arr[i])){
	                System.out.println(" arr[i] "+arr[i]+" "+mp.get(arr[i]));
	            if(mp.get(arr[i])>numOfOcc){
	                count++;
	                mp.put(arr[i],-99999);
	            }
	            else{  
	                 mp.put(arr[i], (mp.get(arr[i]) + 1));
	                 System.out.println("after putting "+mp.get(arr[i]));
	            }
	            }else{
	                 mp.put(arr[i], 1);
	            }
	            
	            
	        }
	        return count;
	    }

}
