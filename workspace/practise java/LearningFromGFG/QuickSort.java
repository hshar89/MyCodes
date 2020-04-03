package LearningFromGFG;
/* This function takes last element as pivot, 
places the pivot element at its correct 
position in sorted array, and places all 
smaller (smaller than pivot) to left of 
pivot and all greater elements to right 
of pivot */
public class QuickSort {
   public int partition(int arr[],int low, int high){
	   int pivot = arr[high];
	   int i = (low-1);
	   for( int j=low;j<high;j++){
		   if(arr[j]<=pivot){
			   i++;
			   int temp = arr[i];
			   arr[i] = arr[j];
			   arr[j] = temp;
		   }
	   }
	   int temp = arr[i+1];
	   arr[i+1] = arr[high];
	   arr[high] = temp;
      return i+1;			   
   }
   
   public void sort(int[] arr, int low, int high){
	   if(low<high){
		   /* pi is partitioning index, arr[pi] is  
           now at right place */
		   int pi = partition(arr,low,high);
		   // Recursively sort elements before 
           // partition and after partition 
		   sort(arr,low,pi-1);
		   sort(arr,pi+1,high);
	   }
   }
   static void printArray(int arr[]) 
   { 
       int n = arr.length; 
       for (int i=0; i<n; ++i) 
           System.out.print(arr[i]+" "); 
       System.out.println(); 
   } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 75, 8, 92, 21, 55};
		int arr2[] = {10, 80, 30, 90, 40, 50,70};
		 QuickSort qs1 = new QuickSort();
		 qs1.sort(arr2, 0, arr2.length-1);
		 System.out.println("sorted array1"); 
	        printArray(arr2); 
        int n = arr.length; 
        QuickSort qs2 = new QuickSort();
        qs2.sort(arr, 0, n-1);
        
        System.out.println("sorted array2"); 
        printArray(arr); 
	}

}
