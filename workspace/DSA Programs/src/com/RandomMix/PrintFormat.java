package PractiseJavaPrograms;
import java.text.*;
public class PrintFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         float result = 335/7;
         DecimalFormat d = new DecimalFormat("#.##");
         System.out.println(d.format(result));
         int [] arr = {1,2, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 1, 0};
         System.out.println("is majority element "+majorityElement(arr,arr.length));
         String ab = "52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145 146";
         String[] abA = ab.split("\\s+");
         long[] arr1 = new long[abA.length];
         for(int i=0;i<arr1.length;i++){
        	 arr1[i] = Long.parseLong(abA[i]);
         }
         //System.out.println("find floor "+findFloor(arr1,0,arr1.length-1,104));
         
         //String bc = "174 194 197 198 205 213 216 220 224 241 250 251 255 257 258 260 264 268 284 290 296 297 299 303 305 309 317 318 323 324 328 337 342 351 355 359 362 371 376 378 389 391 397 400 404 413 419 423 430 440 446 447 451 466 473 474 480 485 489 496 502 508 509 511 513 528 529 530 531 534 539 541 552 555 559 562 573 581 588 590 592 601 608 609 612 618 623 624 629 644 651 657 662 683 686 691 706 707 708 716 719 727 736 738 742 743 747 758 763 764 766 769 773 775 780 781 785 798 801 806 810 816 818 829 830 832 836 837 840 845 848 853 867 875 879 880 882 883 888 890 898 900 909 912 918 930 944 945 957 959 970 971 973 976 977 982 984 992 3 9 20 21 27 39 41 47 54 56 58 70 73 75 84 92 95 108 117 119 121 124 129 130 131 132 139 142 151 153 167 168 172 173";
         String bc = "1 2 1 3 4 3";
         bc="12 5 15 17 4 1 2 9 13 16 3 7 6 10 14 11 4 19 8 18 2";
         abA = bc.split("\\s+");
         int[] arr2 = new int[abA.length];
         for(int i=0;i<arr2.length;i++){
        	 arr2[i] = Integer.parseInt(abA[i]);
         }
         //System.out.println("min number "+findMin(arr2,0,arr2.length-1));
         
         twoRepeated(arr2,arr2.length-2);
	}
	/*Below method checks whether a number is repeated in an consecutively sorted
	 * array and prints the number with the frequecy. Consecutive sorted means always
	 * increasing by one in value
	 */
	 static void repeatedElements(int[] arr, int n){
	     int i=0,times=1,ele=0;
	     while(i<n-1){
	         if(arr[i+1]==arr[i]){
	            times++;
	            ele = arr[i];
	         }
	         i++;
	         }
	         System.out.println(ele+" "+times);
	 }
	static void twoRepeated(int[] arr,int n){
		StringBuffer ab = new StringBuffer();
        int[] a2 = new int[n];
	     for(int j=0;j<arr.length;j++){
	    	 a2[arr[j]-1] -= 1;
	    	 if(a2[arr[j]-1] == -2){
	    	     ab.append(arr[j]+" ");
	    	 }
	     }
	        System.out.print(ab);
	}
	static int findMin(int arr[], int low, int high)
    {
        
		 // This condition is needed to handle the case when array 
        // is not rotated at all 
        if (high < low)  return arr[0]; 
  
        // If there is only one element left 
        if (high == low) return arr[low]; 
  
        // Find mid 
        int mid = low + (high - low)/2; /*(low + high)/2;*/
  
        // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
        if (mid < high && arr[mid+1] < arr[mid]) 
            return arr[mid+1]; 
  
        // Check if mid itself is minimum element 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return arr[mid]; 
  
        // Decide whether we need to go to left half or right half 
        if (arr[high] > arr[mid]) 
            return findMin(arr, low, mid-1); 
        return findMin(arr, mid+1, high); 
    }
    
	static int findFloor(long arr[], int left, int right, long x)
    {   if(x>arr[arr.length-1]){
        return arr.length-1;
        }
        if(right>left){
        int mid = left+(right-left)/2;
        System.out.println("mid "+arr[mid]+" "+mid);
        if(arr[mid] == x || (arr[mid]<x && arr[mid+1]>=x)){
            return mid;
        }
        if(arr[mid]>x){
        	System.out.println("came in if ");
           return findFloor(arr,left,mid-1,x);
        }else{
        	System.out.println("came in else ");
           return findFloor(arr,mid+1,right,x); 
        }
        }
        return -1;
    }
	 static int majorityElement(int a[], int size)
	    {
	        // your code here
	        int moreThanNTwo = size/2;
	        System.out.println("mid "+moreThanNTwo);
	        for(int i=0;i<moreThanNTwo;i++){
	            int freq = 0,j=i;
	            //if(size == 14){
	            //}
	            while(j<size){
	                if(a[j] ==a[i]){
	                    freq++;
	                }
	                if(freq> moreThanNTwo){
	                    return a[i];
	                }
	                j++;
	            }
	            System.out.println("a[i] "+a[i]);
	            System.out.print("freq "+freq);
	            System.out.println();
	        }
	        return -1;
	    }

}
