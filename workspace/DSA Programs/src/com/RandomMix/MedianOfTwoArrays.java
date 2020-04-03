package PractiseJavaPrograms;

public class MedianOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int ar1[] = {1,2,3,4,5}; //1, 12, 15, 26, 38
        //int ar2[] = {11,12,13,14,15,16,17,18}; //2, 13, 17, 30, 45
        int [] ar1 = {2,6};
        int [] ar2 = {1,5,7,12};  
        
        int n1 = ar1.length; 
        int n2 = ar2.length; 
        if (n1 == n2) 
            System.out.println("Median is " + 
            		medianOfSameSizeArrays(ar1, ar2, n1)); 
        else
            System.out.println("arrays are of unequal size"); 
        
        System.out.println("approach 2 for median ");
       
        if (n1 == n2)  
            System.out.println("Median is " + getMedianApproach2(ar1,0,n1-1,ar2,0,n2-1));  
        else
            System.out.println("Doesn't work for arrays "+ "of unequal size"); 
        System.out.println("this is unequal size array");
        System.out.println("median "+findMedianDiffSize(ar1,n1,ar2,n2));
        //System.out.println("median "+medianOfDifferentSizeArrays1(ar1,n1,ar2,n2));
    }  
	// A wrapper function around findMedianUtil(). This function 
	// makes sure that smaller array is passed as first argument 
	// to findMedianUtil 
	public static int findMedianDiffSize(int[] arr1,int n, int[] arr2, int m){
		if(n>m){
			return medianOfDifferentSizeArrays(arr2,m,arr1,n);
		}else{
			return medianOfDifferentSizeArrays(arr1,n,arr2,m);
		}
	}
	// This function assumes that N is smaller than or equal to M 
	// This function returns -1 if both arrays are empty 
	public static int medianOfDifferentSizeArrays(int[] arr1, int n, int[] arr2, int m){
		// If smaller array is empty, return median from second array 
	      if(n==0){
	    	  return median(arr2,0,m-1);
	      }
	   // If the smaller array has only one element 
	      if(n==1){
	    	  if(m==1){
	    		  return (arr1[0]+arr2[0])/2;
	    	  }
	    	// Case 2: If the larger array has odd number of elements, 
	          // then consider the middle 3 elements of larger array and 
	          // the only element of smaller array. Take few examples 
	          // like following 
	          // A = {9}, B[] = {5, 8, 10, 20, 30} and 
	          // A[] = {1}, B[] = {5, 8, 10, 20, 30} 
	    	  if((m & 1) == 1){
	    		  int m1 = Math.min(arr2[(m/2)+1],Math.max(arr2[(m/2)-1],arr1[0]));
	    		  return (m1+arr2[m/2])/2;
	    	  }else{
	    		// Case 3: If the larger array has even number of element, 
	    	        // then median will be one of the following 3 elements 
	    	        // ... The middle two elements of larger array 
	    	        // ... The only element of smaller array 
	    		  return Math.min(arr2[(m/2)+1], Math.max(arr2[m/2], arr1[0]));
	    	  }
	      }else if(n==2){
	    	// Case 4: If the larger array also has two elements,
	    	  if(m==2){
	    		  return (Math.max(arr1[0], arr2[0])+Math.min(arr1[1], arr2[1]))/2;
	    	  }
	    	  // Case 5: If the larger array has odd number of elements, 
	          // then median will be one of the following 3 elements 
	          // 1. Middle element of larger array 
	          // 2. Max of first element of smaller array and element 
	          //    just before the middle in bigger array 
	          // 3. Min of second element of smaller array and element 
	          //    just after the middle in bigger array 
	    	  if((m&1) ==1){
	    		 return Math.min(Math.min(arr2[(m/2)+1], arr1[1]), Math.max(arr2[m/2],Math.max(arr2[(m/2)-1], arr1[0])));
	    	  }else{
	    		// Case 6: If the larger array has even number of elements, 
	    	        // then median will be one of the following 4 elements 
	    	        // 1) & 2) The middle two elements of larger array 
	    	        // 3) Max of first element of smaller array and element 
	    	        //    just before the first middle element in bigger array 
	    	        // 4. Min of second element of smaller array and element 
	    	        //    just after the second middle in bigger array     		
	    		  return (Math.max(arr2[(m/2)-1],Math.max(arr1[0], arr2[(m/2)-2]))+Math.min(arr2[m/2],Math.min(arr1[1], arr2[(m/2)+1])))/2;
	    	  }
	      }else{
	    	  int indxA = (n-1)/2;
	    	  int indxB = (m-1)/2;
	    	  /* if A[idxA] <= B[idxB], then median must exist in 
	          A[idxA....] and B[....idxB] */
	    	  if(arr1[indxA]<arr2[indxB]){
	    		 return -1;//findMedianUtil(A + idxA, N/2 + 1, B, M - idxA );  
	    	  }else{
	    		  /* if A[idxA] > B[idxB], then median must exist in 
	    	       A[...idxA] and B[idxB....] */
	    		  return -1;//findMedianUtil(A, N/2 + 1, B + idxA, M - idxA );
	    	  }
	      }
	}
	/*
	 * This method has an array with already merged elements of two different
	 * sorted arrays. We sort the array keeping this fact in mind and
	 * then find the required median
	 */
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
	 /* This function returns median of ar1[] and ar2[].  
	 Assumption in this function:  
	 Both ar1[] and ar2[] are sorted arrays */
   public static int medianOfDifferentSizeArrays1(int[] ar1, int n, int[] ar2, int m){
	   int i = 0; /* Current index of input array ar1[] */
	    int j = 0; /* Current index of input array ar2[] */
	    int count;  
	    int m1 = -1, m2 = -1;  
	  
	    // Since there are (n+m) elements,  
	    // There are following two cases  
	    // if n+m is odd then the middle  
	    //index is median i.e. (m+n)/2  
	    if((m + n) % 2 == 1)  
	    {  
	        for (count = 0; count <= (n + m)/2; count++) 
	        {  
	            if(i != n && j != m) 
	            {  
	                m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];  
	            }  
	            else if(i < n) 
	            {  
	                m1 = ar1[i++];  
	            }  
	            // for case when j<m,  
	            else
	            {  
	                m1 = ar1[j++];  
	            }  
	        }  
	        return m1;  
	    }  
	      
	    // median will be average of elements  
	    // at index ((m+n)/2 - 1) and (m+n)/2  
	    // in the array obtained after merging ar1 and ar2  
	    else 
	    {  
	        for (count = 0; count <= (n + m)/2; count++)  
	        {  
	            m2 = m1;  
	            if(i != n && j != m) 
	            {  
	                m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];  
	            }  
	            else if(i < n) 
	            {  
	                m1 = ar1[i++];  
	            }  
	            // for case when j<m,  
	            else
	            {  
	                m1 = ar1[j++];  
	            }  
	        }  
	        return (m1 + m2)/2;  
	    }  
   }
   public static int medianOfSameSizeArrays(int[] arr1, int[] arr2, int n){
	   int i=0,j=0,count;
	   int m1 = -1, m2=-1;
	   for(count =0;count<=n;count++){
	   if(i==n){
		   m1 = m2;
		   m2 = arr2[0];
		   break;
	   }
	   if(j==n){
		   m1 = m2;
		   m2 = arr1[0];
		   break;
	   }
	   if(arr1[i]<arr2[j]){
		  m1 = m2;
		  m2 = arr1[i];
		  i++;
	   }else{
		   m1 = m2;
		   m2 = arr2[j];
		   j++;
	   }
	   }
	   return (m1+m2)/2;
   }
   public static int getMedianApproach2(int[] arr1,int sa1, int ea1, int[] arr2, int sa2, int ea2){
	   if((ea1-sa1+1)==1 || (ea2-sa2+1) == 1){
		   return (arr1[sa1]+arr2[sa2])/2;
	   }
	   if((ea1-sa1+1)==2 || (ea2-sa2+1) ==2){
		   return (Math.max(arr1[sa1], arr2[sa2])+Math.min(arr1[ea1], arr2[ea2]))/2;
	   }
	   
	   int m1 = median(arr1,sa1,ea1);
	   
	   int m2 = median(arr2,sa2,ea2);
	   System.out.println("median1 "+m1+" median2 "+m2);
	   if(m1 == m2){
		   return m1;
	   }
	   
	   if(m1<m2){	   
		   return getMedianApproach2(arr1,(ea1-sa1)/2,ea1,arr2,sa2,(ea2+sa2)/2);
	   }else{
		   return getMedianApproach2(arr1,sa1,(ea1-sa1)/2,arr2,(ea2-sa2)/2,ea2);
	   }
   }
   /* Function to get median  
   of a sorted array */
   static int median(int arr[], int s, int e)  
   {   int size = e-s+1;
       if (size% 2 == 0)  
           return (arr[(e-s)/ 2] + arr[((e-s)/ 2) +1]) / 2;  
       else
           return arr[s+((e-s) / 2)];  
   }  
}
