package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchAnElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = {23, 29,112, 344,897, 1110, 1188, 3492, 7832, 8892,10992};
      System.out.println("This is Binary Search Recursive ");
      System.out.println("Found element "+binarySearchRecursive(arr,0,arr.length-1,3492));
      System.out.println("This is Binary Search Iterative ");
      System.out.println("Found element "+binarySearchIterative(arr,0,arr.length-1,3492));
      System.out.println("This is ternary Search Recursive ");
      System.out.println("Found element "+TernarySearchRecursive(arr,0,arr.length-1,3492));
      System.out.println("This is ternary Search Iterative ");
      System.out.println("Found element "+TernarySearchIterative(0,arr.length-1,3492,arr));
      System.out.println("This is java built in Arrays Binary Search ");
      
      byte byteArr[] = {10,20,15,22,35};
      char charArr[] = {'g','p','q','c','i'};
      int intArr[] = {10,20,15,22,35};
      double doubleArr[] = {10.2,15.1,2.2,3.5};
      float floatArr[] = {10.2f,15.1f,2.2f,3.5f};
      short shortArr[] = {10,20,15,22,35};
      
      Arrays.sort(byteArr);
      Arrays.sort(charArr);
      Arrays.sort(intArr);
      Arrays.sort(doubleArr);
      Arrays.sort(floatArr);
      Arrays.sort(shortArr);
      
      byte byteKey = 35;
      char charKey = 'g';
      int intKey = 22;
      double doubleKey = 1.5;
      float floatKey = 35;
      short shortKey = 5;
      
	  System.out.println(byteKey + " found at index = "
	              +Arrays.binarySearch(byteArr,byteKey));
	System.out.println(charKey + " found at index = "
	              +Arrays.binarySearch(charArr,charKey));
	System.out.println(intKey + " found at index = "
	              +Arrays.binarySearch(intArr,intKey));
	System.out.println(doubleKey + " found at index = "
	              +Arrays.binarySearch(doubleArr,doubleKey));
	System.out.println(floatKey + " found at index = "
	              +Arrays.binarySearch(floatArr,floatKey));
	System.out.println(shortKey + " found at index = "
	          +Arrays.binarySearch(shortArr,shortKey));
	
	 System.out.println("This is java built in Collections Binary Search ");
	List al = new ArrayList();
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(10);
    al.add(20);
    
    // 10 is present at index 3.
    int index = Collections.binarySearch(al, 10);
    System.out.println(index);
    index = Collections.binarySearch(al, 15);
    System.out.println(index);
    System.out.println(Math.sqrt(18467d));
	}
    static int binarySearchRecursive(int[] arr, int l, int r, int x){
    	if(r>=l){
    		int mid = l+(r-l)/2;
    		
    		if(arr[mid] == x){
    			return mid;
    		}
    		
    		if(x>arr[mid]){
    			return binarySearchRecursive(arr,mid+1,r,x);
    		}
    		if(x<arr[mid]){
    			return binarySearchRecursive(arr,l,mid-1,x);
    		}
    	}
    	return -1;
    }
    static int binarySearchIterative(int[] arr, int l, int r, int x){
    	while(r>=l){
    		int mid = l+(r-l)/2;
    		if(arr[mid] == x){
    			return mid;
    		}
    		if(x>arr[mid]){
    			l=mid+1;
    		}
    		if(x<arr[mid]){
    			r=mid-1;
    		}
    	}
    	return -1;
    }
    static int TernarySearchRecursive(int[] arr, int l, int r, int x){
    	if(r>=l){
    		int mid1 = l+(r-l)/3;
    		int mid2 = r - (r-l)/3;
    		if(x == arr[mid1]){
    			return mid1;
    		}
    		if(x == arr[mid2]){
    			return mid2;
    		}
    		
    		if(x<arr[mid1]){
    			return TernarySearchRecursive(arr,l,mid1-1,x);
    		}else if(x>arr[mid2]){
    			return TernarySearchRecursive(arr,mid2+1,r,x);
    		}else{
    			return TernarySearchRecursive(arr,mid1+1,mid2-1,x);
    		} 		
    		
    	}
    	return -1;
    }
    static int TernarySearchIterative(int l, int r, int key, int ar[]){
    	 while (r >= l) { 
    		  
    	        // Find mid1 and mid2 
    	        int mid1 = l + (r - l) / 3; 
    	        int mid2 = r - (r - l) / 3; 
    	  
    	        // Check if key is present at any mid 
    	        if (ar[mid1] == key) { 
    	            return mid1; 
    	        } 
    	        if (ar[mid2] == key) { 
    	            return mid2; 
    	        } 
    	        if (key < ar[mid1]) { 
    	        	  
    	            // The key lies in between l and mid1 
    	            r = mid1 - 1; 
    	        } 
    	        else if (key > ar[mid2]) { 
    	  
    	            // The key lies in between mid2 and r 
    	            l = mid2 + 1; 
    	        } 
    	        else { 
    	  
    	            // The key lies in between mid1 and mid2 
    	            l = mid1 + 1; 
    	            r = mid2 - 1; 
    	        } 
         }
    	    return -1;
    }
}
