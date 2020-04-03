package com.RandomMix;

import java.util.ArrayList;
import java.util.Arrays;

public class TestProgram {
    static final int MAX = 1000000;
    private static final int RANGE =255;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/* int aA[][][] = new int[10][11][12];
	 int count=0;
	 for(int i=1;i<10;i++) {
		 for(int j=i;j<11;j++) {
			 for(int k=j;k<12;k++) {
				count++; 
			 }
		 }
	 }
	 int n=100;
	 int m=32;
	 count = 0;
	 for(int i=n;i>=1;i=i/2) {
		 for(int j=m;j>=i;j--) {
			 count++;
		 }
	 }
	 System.out.println("count: "+count);
    /* System.out.println(fun2(2,4));
     StringBuffer sb = new StringBuffer("g");
     System.out.println(sb.toString());
     int[] arr = {2,4,8,3,4,9};
     System.out.println("arr reverse ");
     arrayReversal(arr,arr.length);
     for(int ai: arr){
    	 System.out.print(ai+" ");
     }
     maximumAdjacent(5,arr);
     System.out.println("reversing in group ");
     ArrayList<Integer> al = new ArrayList<Integer>();
     al.add(1);
     al.add(2);
     al.add(3);
     al.add(4);
     al.add(5);
     al.add(6);
     al.add(7);
     al.add(8);
     al.add(9);
     al.add(10);
     al.add(11);
     reverseInGroups(al,al.size(),4);
     al.forEach(n->System.out.print(n+" "));
     int a = Integer.MAX_VALUE;
     System.out.println("For maximum occured element");
     int[] L = { 1, 4, 9, 13, 21 }; 
     int[] R = { 15, 8, 12, 20, 30 }; 
     int n = L.length; 
     System.out.println(maximumOccuredElement(L, R, n)); 
     String abc = "test";
     String a = "9 2 7 9 7 9 3 5 4 4";
     a ="5 4 3 2 1 1 1 1 2";
     String aA[] = a.split("\\s+");
     int arr[] = new int[aA.length];
     for(int i=0;i<aA.length;i++) {
    	 arr[i] = Integer.parseInt(aA[i]);
     }
     //JNext(arr,arr.length);
     System.out.println("This is part 2");
     //JNext2(arr,arr.length);
     int at = (int)'(';
     System.out.println("(: "+at);
     int arrCoins[] = {1,3,5};
     int sum = 11;
     System.out.println(findMinCoins(arrCoins,sum));
	 int arr[] = {3,5,9,2,8,12};
	 int arr2[] = {16, 41, 39, 32, 26, 27, 42, 41, 47, 29, 46, 15, 39, 43, 6 ,35, 26, 48, 22, 25};
	 int n = arr.length;
	 System.out.println("Sorting using bubble sort: ");
	 bubbleSort(arr,arr.length);
	 System.out.println(Arrays.toString(arr));
	 
	 System.out.println("Sorting using insertion sort: ");
	 insertionSort(arr2,arr2.length);
	 System.out.println(Arrays.toString(arr2));
	 String s = "22 9 20 45 47 40 44 15 33 2 20 25 28 30 30 44 5 50 10 13";
	 int arr3[] = stringToIntegerArray(s);
	 
	 System.out.println("BinaryInsertion Sort: ");
	 binaryInsertionSort(arr3,arr3.length);
	 System.out.println(Arrays.toString(arr3));
	 
	 System.out.println("Sorting using selection sort: ");
	 s = "45 8 5 48 33 4 24 32 32 17 3 31 24 11 48 20 47 17 25 42";
	 int arr4[] = stringToIntegerArray(s);
	 selectionSort(arr4,arr4.length);
	 System.out.println(Arrays.toString(arr4));
	 
	 System.out.println("Sorting using quick sort");
	 //s = "17 49 41 36 31 38 19 47 24 36";
	    //17 19 24 21 36 36 38 41 47 49
	 s = "8 33 24 28 18 7 15 41 37 18 35 50 16 15 29 30 4 11 11 4 17 44 19 15 27 31 5 31 46 22";
	 int arr5[] = stringToIntegerArray(s); 
	 quickSort(arr5,0,arr5.length-1);
	 System.out.println(Arrays.toString(arr5));
	 
	 System.out.println("This is optimized quick sort");
	 s ="30 7 28 42 28 27 19 45 49 49";
	 int arr6[] = stringToIntegerArray(s);
	 quickSortOptimized(arr6,0,arr6.length-1);
	 System.out.println(Arrays.toString(arr6));
	 
	 System.out.println("Hoarses implementation of quick sort");
	 s = "17 49 41 36 31 38 19 47 24 36";
	 int arr7[] = stringToIntegerArray(s);
	 quickSortHoarses(arr7,0,arr7.length-1);
	 System.out.println(Arrays.toString(arr7));
	 
	 System.out.println("\nThis is 3 way quick sort");
	 s ="3 5 1 7 10 5 10 8 2 3 3 2 6 6 2 6 5 1 4 10";
	 int arr8[]= stringToIntegerArray(s);
	 int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
	 //System.out.println(Arrays.toString(a));
	 threeWayQuickSort(arr8,0,arr8.length-1);
	 System.out.println(Arrays.toString(arr8));
	 
	 System.out.println("\nThis my friends is merge sort");
	 //s="4 5 9 5 9 10 10 10 2 2 2 6 9 8 1 5 7 10 1 9";
	 s="9 28 20 15 26 28 16 14 18 2 25 6 24 11 20 5 6 21 23 8 6 3 2 9 6 5 1 8 13 21 17 1 25 15 30 7 24 18 21 7";
	 int arr9[] = stringToIntegerArray(s);
	 System.out.println(Arrays.toString(arr9));
	 mergeSort(arr9,0,arr9.length-1);
	 System.out.println(Arrays.toString(arr9));
	 
	 System.out.println("\nThis is merge sort In place");
	 s ="17 25 15 26 11 22 9 22 5 13 24 25 8 20 12";
	 int arr10[] = stringToIntegerArray(s);
	 mergeSortInplace(arr10,arr10.length);
	 System.out.println(Arrays.toString(arr10));
	 
	 System.out.println("This is counting sort");
	 s ="jhcbdbkkia";
	 char ch[] = s.toCharArray();
	 countSort(ch);
	 
	 System.out.println("This is count sort including negative numbers");
	 
	 s="-7 14 -10 26 27 -7 29 -3 5 3 28 21 17 -9 10";
	 int arr11[]= stringToIntegerArray(s);
	 System.out.println(Arrays.toString(arr11));
	 countSortNegativeAlso(arr11);
	 int an = 100000;
	 long sum = ((an)*(an+1))/2;
	 System.out.println("sum: "+sum);
	 System.out.println(1<<2);
	 System.out.println("This is upper bound on binary search");
	 System.out.println(Arrays.toString(arr10));
	 int tosearch = 19;
	 System.out.println("upper bound for: "+tosearch+" "+binarySearch(arr10, 0,arr10.length-1,tosearch));
	 System.out.println("This is code chef question ");
	 String sb = "????CIELISOUR???F";
	 formchef(sb);
	 
	 System.out.println("THis is gcd boys "+gcd(20,17));
	 System.out.println("This is LCM of an array");
	 s ="39 10 74 98 10 35 71 18 18 28";
	 s ="4 3 6 8 9";
	 int arr12[] = stringToIntegerArray(s);
	 System.out.println(LCMArray(arr12));*/
    System.out.println((int)'A');
	}
	private static void formchef(String ab) {
		 int n = ab.length();
		 char chef[] = {'F','E','H','C'};
		 char ch[] = new char[n];
		 int chefIndex= 0;
		 int i=n-1;
		    while(i>=0){
		        if(chefIndex==4){
		            chefIndex = 0;
		        }
		        if(ab.charAt(i)=='?'){
		           ch[i] = chef[chefIndex];
		           chefIndex++;
		        }else{
		            ch[i] = ab.charAt(i);
		            if(ab.charAt(i)!=chef[chefIndex]){
		                int j= i+1;
		                while(j<=(i+chefIndex)){
		                 ch[j] = ab.charAt(j)=='?'?'A':ab.charAt(j); 
		                 j++;
		                }
		               chefIndex= ab.charAt(i)==chef[0]?1:0;  
		            }else{
		                chefIndex++;
		            }
		        }
		        i--;
		    }
	 if(chefIndex>0 && chefIndex<4){
		        int j=0;
        while(j<n && j<chefIndex){
		   ch[j] = ab.charAt(j)=='?'?'A':ab.charAt(j); 
		       j++;
		      }  
	  }
	}
	//This calculates fast LCM of array elements
	private static long LCMArray(int arr[]) {
		int n = arr.length;
		long ans = arr[0];
		for(int i=1;i<n;i++) {
			ans = (ans*arr[i])/(gcd(ans,arr[i]));
		}
		return ans;
	}
	//This calculates fast gcd
	private static long gcd(long a, long b) {
		while(b>0) {
			long rem  = a%b;
			a = b;
			b = rem;
		}
		return a;
	}
	//This is upper bound on binarySearch
	private static int binarySearch(int arr[], int lo, int hi, int x) {
		if(x<arr[lo]) {
			return lo;
		}
		if(x>arr[hi]) {
			return -1;
		}
		int mid = lo+(hi-lo)/2;
		if(x==arr[mid]) {
			return binarySearch(arr,mid+1,hi,x);
		}
			
		if(arr[mid]<x){
			    if(mid+1<=hi && x<arr[mid+1]) {
			    	return mid+1;
			    }
		    return binarySearch(arr,mid+1,hi,x);
	    }else{
	    	if(mid-1>=lo && x>=arr[mid-1]) {
	    		return mid;
	    	}
	      return binarySearch(arr,lo,mid-1,x);	
	    }
	}
	//This is counting sort for negative numbers
	private static void countSortNegativeAlso(int arr[]) {
		int n  = arr.length;
		int minele = Integer.MAX_VALUE;
		int maxele = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i]>maxele) {
				maxele = arr[i];
			}
			if(arr[i]<minele) {
				minele = arr[i];
			}
		}
		int range = maxele-minele+1;
		System.out.println("Range: "+range);
		int count[] = new int[range];
		for(int i=0;i<n;i++) {
			count[arr[i]-minele]++;
		}
		//System.out.println(Arrays.toString(count));
		for(int i=1;i<range;i++) {
			count[i] +=count[i-1];
		}
		//System.out.println(Arrays.toString(count));
		int output[] = new int[n];
		for(int i=0;i<n;i++) {
		   output[count[arr[i]-minele]-1] = arr[i];
		   count[arr[i]-minele]--;
		}
		System.out.println(Arrays.toString(output));
	}
	//This is counting sort 
	private static void countSort(char ch[]) {
	    int count[] = new int[RANGE+1];
	    int n = ch.length;
	    for(int i=0;i<n;i++) {
	    	count[ch[i]]++;
	    }
	    for(int i=1;i<=RANGE;i++) {
	    	count[i] += count[i-1];
	    }
	    char output[] = new char[n];
	    for(int i=0;i<n;i++) {
	    	output[count[ch[i]]-1] = ch[i];
	    	count[ch[i]]--;
	    }
	    System.out.println(Arrays.toString(output));
	}
	
	//This is inplace implementation of merge sort
	private static void mergeSortInplace(int arr[], int n) {
		int maxele = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			maxele = Math.max(arr[i], maxele);
		}
		mergeSortIP(arr,0,n-1,maxele+1);
	}
	private static void mergeSortIP(int[] arr, int i, int j, int maxele) {
		// TODO Auto-generated method stub
		if(i<j) {
			int mid = i+(j-i)/2;
			mergeSortIP(arr,i,mid,maxele);
			mergeSortIP(arr,mid+1,j,maxele);
			mergeIP(arr,i,mid,j,maxele);
		}
	}
	private static void mergeIP(int[] arr, int lo, int mid, int hi,int maxele) {
		// TODO Auto-generated method stub
		int i = lo;
		int j=mid+1;
		int k = lo;
		while(i<=mid && j<=hi) {
			if(arr[i]%maxele <=arr[j]%maxele) {
				arr[k] = arr[k] + (arr[i]%maxele)*maxele;
				k++;
				i++;
			}else {
				arr[k] = arr[k]+(arr[j]%maxele)*maxele;
				k++;
				j++;
			}
		}
		while(i<=mid) {
			 arr[k] = arr[k] + (arr[i] % maxele) * maxele; 
		        k++; 
		        i++; 
		}
		while(j<=hi) {
			 arr[k] = arr[k] + (arr[j] % maxele) * maxele; 
		        k++; 
		        j++;
		}
		
		for(int r=lo;r<=hi;r++) {
			arr[r] = arr[r]/maxele;
		}
		
	}
	
	//Merge sort for arrays
	private static void mergeSort(int arr[], int low, int high) {
		if(low<high) {
			int mid = low+(high-low)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	//For merging two sorted arrays
	private static void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int n1 = mid-low+1;
		int n2 = high-mid;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i=low;i<=mid;i++) {
			L[i-low] = arr[i];
		}
		for(int i=mid+1;i<=high;i++) {
			R[i-mid-1] = arr[i];
		}
		int i=0,j=0,k=low;
		while(i<n1 && j<n2) {
			if(L[i] >=R[j]) {
				arr[k++] = R[j++]; 
			}else {
				arr[k++] = L[i++];
			}
		}
		while(i<n1) {
			arr[k++] = L[i++];
		}
		while(j<n2) {
			arr[k++] = R[j++];
		}
	}
	//Three way quick sort
	/* This function partitions a[] in three parts 
	a) a[l..i] contains all elements smaller than pivot 
	b) a[i+1..j-1] contains all occurrences of pivot 
	c) a[j..r] contains all elements greater than pivot */
	private static void threeWayQuickSort(int arr[], int low, int high) {
		if(high<=low) {
			return;
		}
		int arrtemp[] = {0,0};
		partitionForThreeWay(arr,low,high,arrtemp);
		threeWayQuickSort(arr,low,arrtemp[0]);
		threeWayQuickSort(arr,arrtemp[1],high);
	}
	
	private static void partitionForThreeWay(int[] arr, int low, int high, int[] arrtemp) {
		
		if(high-low<=1) {
			if(arr[high]<arr[low]) {
			swap(arr,low,high);
			}
			arrtemp[0]=low;
			arrtemp[1] = high;
			return;
		}
		
		int mid = low;
		int pivot = arr[high];
		while(mid<=high) {
			if(arr[mid]<pivot) {
				swap(arr,mid++,low++);
			}else if(arr[mid]==pivot) {
				mid++;
			}else if(arr[mid]>pivot) {
				swap(arr,mid,high--);
			}
		}
		arrtemp[0] = low-1;
		arrtemp[1] = mid;
	}
	
	//Quick sort based on Hoarse's Partition scheme
	private static void quickSortHoarses(int arr[], int low, int high) {
		if(low<high) {
			/* pos is partitioning index, arr[p] is now 
	           at right place */
			int pos = partitionHoarses(arr,low,high);
			// Separately sort elements before 
	        // partition and after partition 
			quickSortHoarses(arr,low,pos);
			quickSortHoarses(arr,pos+1,high);
		}
	}
	
	private static int partitionHoarses(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int i=low-1;
		int j = high+1;
		int pivot = arr[low];
		while(true) {
			// Find leftmost element greater than 
	        // or equal to pivot
			do {
				i++;
			}while(arr[i]<pivot);
			// Find rightmost element smaller than 
	        // or equal to pivot 
			do {
				j--;
			}while(arr[j]>pivot);
			// If two pointers met.
			if(i>=j) {
				return j;
			}
		int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
		}
	}
	//Optimized version for quick sort
	static void quickSortOptimized(int arr[], int lo, int high) {
		while(lo<high) {
			int pos = partition(arr,lo,high);
			if(pos-lo<high-pos) {
				quickSortOptimized(arr,lo,pos-1);
				lo = pos+1;
			}else {
				quickSortOptimized(arr,pos+1,high);
				high = pos-1;
			}
		}
	}
	//Test program for quick sort
	static void quickSort(int arr[], int lo, int hi) {
		if(lo<hi) {
		int pos = partitionWithRandomElement(arr,lo,hi);
		quickSort(arr,pos+1,hi);
		quickSort(arr,lo,pos-1);
		//System.out.println(Arrays.toString(arr));
		}
	}
	private static int partition(int arr[], int low, int hi) {
		int pivot = arr[hi];
		int i=low,j=low-1;
		while(i<hi) {
			if(arr[i]<pivot) {
				j++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}else {
				i++;
			}
		}
		int temp = arr[j+1];
		arr[j+1] = pivot;
		arr[hi] = temp;
		return j+1;
	}
	//Partition with random element
	//Gets a random number between high and low 
	//swaps that with arr[high] and proceeds to normal partition
	private static int partitionWithRandomElement(int arr[], int low, int high) {
		int random = (int)(Math.random()*(high-low))+low;
		int temp = arr[random];
		arr[random] = arr[high];
		arr[high] = temp;	
		return partition(arr,low,high);
	}
	//Partition with first element as pivot
	private static int partitionFirstElement(int arr[], int low, int high) {
		int pivot = arr[low];
		int i=high,j=high;
		while(i>low) {
			if(arr[i]>pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
				i--;
			}else {
				i--;
			}
		}
		arr[low] = arr[j];
		arr[j] = pivot;
		return j;
	}
	//Test program for selection sort
	static void selectionSort(int arr[], int n) {
		for(int i=0;i<n-1;i++) {
			int min = Integer.MAX_VALUE;
			int minindex = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<min) {
					min=arr[j];
					minindex = j;
				}
			}
			arr[minindex] = arr[i];
			arr[i] = min;
		}
	}
	//Test program binaryInsertionSort
	static void binaryInsertionSort(int arr[], int n) {
		int selected = 0;
		for(int i=1;i<n;i++) {
			int j = i-1;
			selected = arr[i];
			int pos = findPosBinarySearch(arr,0,j,selected);
			while(j>=pos) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = selected;
		}
	}
	private static int findPosBinarySearch(int[] arr, int lo, int hi, int selected) {
		// TODO Auto-generated method stub
		if(lo>=hi) {
			return (selected>arr[lo])?lo+1:lo; 
		}		
			int mid = lo+(hi-lo)/2;
			if(arr[mid]==selected) {
				return mid+1;
			}
			if(arr[mid]>selected) {
				return findPosBinarySearch(arr,lo,mid-1,selected);
			}
			return findPosBinarySearch(arr,mid+1,hi,selected);
	}
	//Test program for Insertion sort
	static void insertionSort(int arr[], int n) {
		for(int i=1;i<n;i++) {
			int key = arr[i];
			int j=i-1;
			for(;j>=0 && arr[j]>key;j--) {
					arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
	}
	//Test program for bubble sort
	static void bubbleSort(int arr[], int n) {
		
		for(int i=0;i<n-1;i++) {
			// Last i elements are already in place 
			boolean swapped =false;
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped=true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	//Helper method to convert String to array
	static int[] stringToIntegerArray(String s) {
		String ab[] = s.split("\\s+");
		int n = ab.length;
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(ab[i]);
		}
		return arr;
	}
	//Find minimum coins to attain a given sum 
	static int findMinCoins(int coinarr[], int sum) {
		int result[] = new int[sum+1];
		for(int i=0;i<result.length;i++) {
			result[i] = Integer.MAX_VALUE;
		}
		result[0] = 0;
		for(int i=1;i<=sum;i++) {
			for(int j=0;j<coinarr.length;j++) {
				if(coinarr[j]<=i && (1+result[i-coinarr[j]])<result[i]) {
					result[i] = 1+result[i-coinarr[j]];
				}
			}
		}
		return result[sum];
	}
	static void JNext2(int arr[], int n) {
		int i,j;
		for(i=n-1;i>0;i--) {
			if(arr[i-1]<arr[i]) {
				break;
			}
		}
		if(i == 0) {
		System.out.println("-1");
		return;
		}
		int x = arr[i-1];
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,i,n);
		for(j=i;j<n-1;j++) {
			if(arr[j]>x) {
				break;
			}
		}
		int temp = arr[j];
		arr[j] = x;
		arr[i-1] = temp;
		for(i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
	}
	static void JNext(int arr[], int n) {
		System.out.println(Arrays.toString(arr));
	    int i,j;
		for(i=n-1;i>0;i--) {
			if(arr[i-1]<arr[i]) {
				break;
			}
		}
		if(i == 0) {
		System.out.println("-1");
		return;
		}
		int smallest = i;
		int x = arr[i-1];
		for(j=i+1;j<n;j++) {
			if(arr[j]<arr[smallest] && arr[j]>x) {
				smallest = j;
			}
		}
		int temp = arr[smallest];
		arr[smallest] = arr[i-1];
		arr[i-1] = temp;
		Arrays.sort(arr, i, n);
		for(i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
	}
	static int fun(int x, int y)
	{
	    if (y == 0)   return 0;
	    return (x + fun(x, y-1));
	    
	}
	static int maximumOccuredElement(int[] L, int[] R, int n) 
    { 
        // Initalising all element of array to 0. 
        int[] arr = new int[MAX]; 
  
        // Adding +1 at Li index and  
        // substracting 1 at Ri index. 
        for (int i = 0; i < n; i++) { 
            arr[L[i]] += 1; 
            arr[R[i] + 1] -= 1; 
        } 
  
        // Finding prefix sum and index 
        // having maximum prefix sum. 
        int msum = arr[0]; 
        int ind = 0; 
        for (int i = 1; i < MAX; i++) { 
        	//System.out.println("arr[i] "+arr[i]);
            arr[i] += arr[i - 1]; 
            if (msum < arr[i]) { 
            	 System.out.println("msum "+msum+" arr[i] "+arr[i]+" i "+i);
                msum = arr[i]; 
                ind = i; 
            } 
           
        } 
  
        return ind; 
    } 
	static int fun2(int a, int b)
	{
	    if (b == 0) return 1;
	    return fun(a, fun2(a, b-1));
	}
	 static void maximumAdjacent(int sizeOfArray, int arr[]){
	         StringBuffer sb = new StringBuffer();
	         for(int i =0;i<sizeOfArray-1;i++){
	             if(arr[i+1]>arr[i]){
	                 sb.append(arr[i+1]+" ");
	                 //sb.append(" ");
	             }else{
	                 sb.append(arr[i]+" ");
	                 //sb.append(" ");
	             }
	         }
	         System.out.print(sb.toString());
	        
	    }
	 public static void arrayReversal(int arr[],int sizeOfArray) 
	    {
	       //Write your code here
	       int f=0,l=sizeOfArray-1;
	       System.out.println(f +" "+ l);
	       while(l>f){
	           swap(arr,f,l);
	           f++;
	           l--;
	       }
	    }
	    private static void swap(int[] arr,int f, int l){
	        int tmp = arr[f];
	        arr[f] = arr[l];
	        arr[l] = tmp;
	    }
	    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
	        // add your code here
	    	if(k>n){
	    		k=n;
	    	}
	    	 /*int parts = n/k;
	         int l=0,h=k-1;
	         for(int i=0;i<=parts;){
	             reverse(mv,l,h);
	             i++;
	             l = i*k;
	             h = (k*(i+1)-1)>n-1?n-1:(k*(i+1)-1);
	             System.out.println("l "+l+" h "+h);
	         }*/
	         for (int i = 0; i < n; i += k) 
	         { 
	             int left = i; 
	       
	             // to handle case when k is not multiple 
	             // of n 
	             int right = Math.min(i + k - 1, n - 1); 
	             reverse(mv,left,right);
	         }
	         return mv; 
	        
	    }
	    static void reverse(ArrayList<Integer> mv, int l, int h){
	        while(h>l){
	            int temp = mv.get(l);
	            mv.set(l,mv.get(h));
	            mv.set(h,temp);
	            l++;
	            h--;
	        }
	    }
	    public static void  printFrequency(int arr[], int n){
	        
	        // Your code here
	        int i=0;
	        while(i<n){
	            if(arr[i]<0){
	                i++;
	                continue;
	            }
	            int elementIndex = arr[i] - 1;
	            if(arr[elementIndex]>0){
	                arr[i] = arr[elementIndex];
	                arr[elementIndex] = -1;
	            }else{
	                arr[elementIndex]--;
	                arr[i] = 0;
	                i++;
	            }
	            
	        }
	        for(int j=0;j<n;j++){
	            System.out.print(Math.abs(arr[j])+" ");
	        }
	    }
}
