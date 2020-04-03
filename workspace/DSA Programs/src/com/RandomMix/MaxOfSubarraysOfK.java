package PractiseJavaPrograms;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxOfSubarraysOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr ={10,5,8,7,3,9,4,15,12,90};
        max_of_subarrays(arr,arr.length,4);
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        
	}
	static void max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
       Deque<Integer> dq = new LinkedList<Integer>();
        int i;
        for(i=0;i<k;i++){
        	// For every element, the previous smaller elements are useless so 
            // remove them from Qi 
        	while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
        		dq.removeLast();// Remove from rear
        	}
        	 // Add new element at rear of queue
        	dq.addLast(i);
        }
        System.out.println("initial queue ");
        dq.forEach(r->System.out.print(arr[r]+" "));
        System.out.println();
        
        StringBuffer sb = new StringBuffer();
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for(;i<n;i++){
        	
        	sb.append(arr[dq.getFirst()]+" ");
        	// Remove the elements which are out of this window 
        	while(!dq.isEmpty()&&dq.getFirst()<=i-k){
        		
        		dq.removeFirst();
        	}
        	 // Remove all elements smaller than the currently 
            // being added element (remove useless elements) 
        	while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
        		
        		dq.removeLast();
        	} 
        	// Add current element at the rear of Qi 
        	dq.addLast(i);
        }
        // Print the maximum element of last window 
        System.out.println(sb+""+arr[dq.peek()]);
    }

}
