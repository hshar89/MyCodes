package LearningFromGFG;
//Merges two subarrays of arr[]. 
// First subarray is arr[l..m] 
// Second subarray is arr[m+1..r] 
/*The below program divides the array into two equal halves
 * which are sorted in themselves and then merge them again
 */
public class MergeSort {
    public void merge(int arr[],int l, int m, int r){
    	System.out.println("Entered merge"+" l "+l+" m "+m+" r "+r);
    	int n1 = m-l+1;   	
    	int n2 = r-m;
    	System.out.println(" n1 "+n1+" n2 "+n2);
    	int L[] = new int[n1];
    	int R[] = new int[n2];
    	
    	for(int i=0;i<n1;i++){
    		L[i] = arr[l+i];
    	}
    	for(int i=0; i<n2;i++){
    		R[i] = arr[m+1+i];
    	}
       System.out.println("array L");
       printArray(L);
       System.out.println("array R");
       printArray(R);
    	
    	 /* Merge the temp arrays */
    	 // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
     // Initial index of merged subarry array 
        int k = l; 
        System.out.println("begin merging arrays k "+k);
        while (i < n1 && j < n2) 
        {   
          System.out.println("L[i] "+L[i]+ " R[j] "+R[j] + " k "+k+" i "+i+" j "+j);
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        /* Copy remaining elements of L[] if any */
        
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
      
        printArray(arr);
    }
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
     // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    {   /*The given array is divided into parts
         *The code drills into the smallest part possible
         *for the first sort and then begins 
         *with the second sort which goes for merge eventually 
         */
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
         System.out.println("Sort## m "+m+ " l "+l+" r "+r);
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6, 7,8,3,4,5,6,10,34,11}; 
		  
        //System.out.println("Given Array"); 
        //printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
	}

}
