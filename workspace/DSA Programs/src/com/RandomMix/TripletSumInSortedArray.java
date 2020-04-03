package PractiseJavaPrograms;

import java.util.Arrays;

/*
 * Consider a sorted array of n numbers and a number x.
 *  What would be the time complexity of the best known algorithm to find a triplet 
 *  with sum equal to x. For example, arr[] = {1, 5, 10, 15, 20, 30},
 *  x = 40. Then there is a triplet {5, 15, 20} with sum 40.
 */
public class TripletSumInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     //int[] arr = {1,5,10,15,20,30};
     int x = 182;
     String ab = "589 343 609 61 222 759 955 889 147 691 950 844 431 621 749 68 537 784 36 227 186 39 854 630 225 749 924 360 258 767 945 956 319 727 412 26 356 2 550 497 585 516 965 343 76 914 143 197 949 73";
     String[] abA = ab.split("\\s+");
     int[] arr = new int[abA.length];
     for(int i=0;i<arr.length;i++){
    	 arr[i] = Integer.parseInt(abA[i]);
     }
     findDoubletsForAGivenSum(arr,arr.length,x);
     findTripletForGivenSum(arr,arr.length,x);
	}
	public static void findDoubletsForAGivenSum(int[] arr, int n, int x){
		Arrays.sort(arr);
		int l=0,r=n-1;
		while(l<r){
			if(arr[l]+arr[r] == x){
				System.out.println(arr[l]+" "+arr[r]);
				return;
			}else if(arr[l]+arr[r] < x){
				l++;
			}else{
				r--;
			}
		}
		System.out.println("No");
	}
	public static void findTripletForGivenSum(int[] arr, int n, int x){
		for(int i=0;i<n-2;i++){
			int l=i+1,r=n-1;
			while(l<r){
				if(arr[i]+arr[l]+arr[r] == x){
					System.out.println(arr[i]+" "+arr[l]+" "+arr[r]);
					return;
				}else if(arr[i]+arr[l]+arr[r] < x){
					l++;
				}else{
					r--;
				}
			}
		}
		System.out.println("No");
	}

}
