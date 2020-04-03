package PractiseJavaPrograms;

import java.util.HashSet;

public class PairSumUsingHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String ab ="990 756 194 137 33 694 112 804 513 842 398 406 660 78 19 310 739 372 613 838 885 384 431 305 925 455 24 606 355 840 240 725 730 781 302 593 264 87 335 858 664 671 468 80 953 670 564 995 413 803 524 912 967 656 74 300 770 508 542 930 445 941 948 75 232 824 533";
       String[] abA = ab.split("\\s+");
       int[] arr = new int[abA.length];
       for(int i=0;i<arr.length;i++){
    	   arr[i] = Integer.parseInt(abA[i]);
       }
       int sum = 133;
       System.out.println("does it exists "+sumExists(arr,arr.length,sum));
	}
	public static int sumExists(int arr[], int n, int sum)
    {
       //Your code here, Geeks
       HashSet<Integer> hs = new HashSet<Integer>();
       for(int i=0;i<n;i++){
           if(hs.contains(sum - arr[i])){
        	   System.out.println(arr[i]);
               return 1;
           }
           hs.add(arr[i]);
       }
       return 0;
    }

}
