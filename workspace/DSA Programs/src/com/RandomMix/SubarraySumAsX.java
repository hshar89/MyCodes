package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumAsX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] arr= {10,2,-2,-20,10};
    int x = -10;
   //givenSumPresent(arr,arr.length,x);

   System.out.println("number of subarrays with sum x "+findSubarraySum(arr,arr.length,x));
	}
	static void givenSumPresent(int[] arr, int n, int x){
		int cur_sum = 0,start=0,end=-1;
		HashMap<Integer,Integer> mp = new HashMap<>();
		
		for(int i=0;i<n;i++){
			cur_sum+=arr[i];
		    if(cur_sum - x == 0){
		    	start =0;
		    	end=i;
		    	break;
		    }
		    if(mp.containsKey(cur_sum-x)){
		    	start = mp.get(cur_sum-x)+1;
		    	end = i;
		    	break;
		    }
		    mp.put(cur_sum, i);
		}
		if(end!=-1){
			System.out.println(start+" "+end);
		}else{
			System.out.println("No sub Array");
		}
	}
	static int findSubarraySum(int[] arr, int n, int x){
		// HashMap to store number of subarrays  
        // starting from index zero having   
        // particular value of sum.  
		HashMap<Integer,Integer> mp = new HashMap<>();
		int res = 0;
		// Sum of elements so far. 
		int curr_sum=0;
		for(int i=0;i<n;i++){
			// Add current element to sum so far.
			curr_sum+=arr[i];
			 // If currsum is equal to desired sum,  
			// then a new subarray is found. So  
			// increase count of subarrays.  
			if(curr_sum == x){
				//System.out.println("curr sum equal x"+" i "+arr[i]+" res "+res);
				res++;
			}
			// currsum exceeds given sum by currsum   
            //  - sum. Find number of subarrays having   
            // this sum and exclude those subarrays  
            // from currsum by increasing count by   
            // same amount.  
			if(mp.containsKey(curr_sum - x)){
				/*System.out.println("map contains diff ");
				System.out.println("curr_sum - x "+(curr_sum - x)+" map value "+
				mp.get(curr_sum-x)+" res "+res);*/
				res += mp.get(curr_sum-x);
			}
			// Add currsum value to count of   
            // different values of sum. 
			Integer count =mp.get(curr_sum);
			if(count == null){
				mp.put(curr_sum, 1);
				
			}else{
				mp.put(curr_sum, count+1);
			}
		}
		for(Integer a: mp.keySet()){
			System.out.println("key "+a+" value "+mp.get(a));
		}
		return res;
	}

}
