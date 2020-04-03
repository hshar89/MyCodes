package PractiseJavaPrograms;

public class MergeSortTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr1 = {1,2,3,4,5};
     int[] arr2 = {3,4,5,6,7,8};
     int[] arr3 = {1,2,3,4,5,3,4,5,6,7,8};
    // String a2 = "36 141 149 237 274 467 619 646 708 781 1030 1053 1065 1112 1121 1227 1306 1407 1720 1786 1834 1837 1874 1892 2165 2217 2241 2347 2410 2479 2495 2550 2650 2686 2710 2733 2893 3149 3247 3266 3270 3272 3281 3424 3429 3437 3459 3460 3533 3544 3559 3613 3616 3639 3676 3733 3919 3920 4082 4168 4204 4230 4316 4324 4366 4611 4783 4806 4848 4967 5203 5218 5239 5360 5367 5387 5397 5401 5401 5622 5801 5987 6156 6190 6239 6241 6354 6359 6366 6477 6930 6936 7098 7124 7179 7420 7465 7563 7625 7718 7729 7878 7896 7910 8250 8271 8278 8470 8675 8696 8772 8812 8886 8963 9092 9177 9469 9488 9514 9518 9792 9918 9957 9965 10076 10142 10142 10378 10412 10424 10505 10509 10704 10731 10951 11005 11027 11048 11066 11095 11100 11203 11375 11411 11491 11502 11742 11745 11848 11991 12045 12048 12289 12416 12449 12522 12586 12606 12613 12640 12663 12754 12776 12848 12895 12897 12918 12991 13101 13277 13341 13458 13476 13580 13600 13672 13738 13896 13908 14122 14289 14308 14377 14441 14449 14464 14577 14662 14815 15121 15124 15174 15348 15529 15547 15564 15588 15754 15916 15946 15965 15971 16103 16469 16476 16506 16522 16599 16608 16624 16727 16744 16787 16790 16908 17056 17128 17276 17338 17424 17628 17653 17810 17822 17889 17944 18311 18340 18392 18565 18603 18621 18830 18843 18902 19062 19198 19321 19363 19560 19597 19629 19818 19914 19948 19993 20026 20050 20068 20104 20222 20265 20366 20406 20501 20537 20560 20578 20709 20766 20892 21032 21071 21116 21119 21121 21129 21141 21239 21346 21354 21419 21442 21494 21765 21866 22116 22176 22386 22413 22454 22710 22958 22979 23046 23084 23152 23321 23337 23389 23392 23449 23578 23682 23733 23744 23812 23882 23889 23932 24006 24076 24093 24106 24153 24190 24222 24334 24408 24610 24627 24705 24730 24791 25072 25080 25091 25162 25171 25279 25415 25449 25468 25600 25667 25741 25765 26157 26414 26424 26457 26697 26733 26754 26827 27013 27024 27258 27410 27435 27703 27736 27796 27852 27923 28241 28272 28337 28501 28600 28681 28733 28934 28998 29089 29192 29257 29467 29481 29547 29556 29576 29613 29623 29643 29666 29722 29789 30058 30074 30105 30157 30440 30534 30558 30567 30629 30641 30710 30773 30799 30876 30971 31051 31151 31163 31374 31421 31428 31468 31574 31715 31731 31798 31843 32007 32130 32417 32438 32492 32524 32574 32599 32707 32738 32748";
    // String a1 = "";
     System.out.print("median "+mergeTwoArrays(arr1,arr2,arr1.length,arr2.length));
   printArray(arr1,arr1.length);
   printArray(arr2,arr2.length);
   System.out.println("this is using the other method ");
   System.out.print("median "+findMedian(arr3,5,6));
   printArray(arr3,arr3.length);
	}
	public static int findMedian(int[] arr, int n, int m){
		 for(int i=(n+m)-1;i>=n;i--){
	         int j, last = arr[n-1];
	         for(j=n-2;j>=0 && arr[j]>=arr[i];j--){
	             arr[j+1] = arr[j];
	         }
	         if(j!=n-2 && last>arr[i]){
	             arr[j+1] = arr[i];
	             arr[i] = last;
	         }
	     }
		    int s = (n+m),median;
		    if(s%2==0){
		     median = (arr[(s-1)/2]+arr[s/2])/2;
		    }else{
		        median = arr[s/2];
		    }
		    return median;
	}
   public static int mergeTwoArrays(int[] arr1, int[] arr2, int n, int m){
	   for(int i=m-1;i>=0;i--){
		   int last = arr1[n-1],j;
		   for(j = n-2;j>=0 && arr1[j]>=arr2[i];j--){
			   arr1[j+1] = arr1[j];
		   }
		   if(j!=n-2 && last>arr2[i]){
			   arr1[j+1] = arr2[i];
			   arr2[i] = last;
		   }
	   }
	   int m1 = (n+m)/2,median;
	    if(m1>n){
	        median = (arr2[m1-n-1]+arr2[m1-n])/2;
	    }else if((m1+1)>n){
	        median = (arr1[m1-1]+arr2[m1-n])/2;
	    }else{
	        median = (arr1[m1-1]+arr1[m1])/2;
	    }
	    return median;
   }
   public static void printArray(int[] arr, int n){
	   System.out.println();
	   for(int i=0;i<n;i++){
		   System.out.print(arr[i]+" ");
	   }
   }
}
