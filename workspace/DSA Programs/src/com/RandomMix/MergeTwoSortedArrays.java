package PractiseJavaPrograms;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] arr1 ={1,3,5,6};
    int[] arr2 ={0,2,7,8,9};
    merge(arr1,arr2,arr1.length,arr2.length);
	}
	public static void merge(int arr1[], int arr2[], int n, int m) 
    {
       // add your code here 
	       int i=m-1,j;
	       while(i>=0){
	           int last = arr1[n-1];
	        for(j=n-2;j>=0 && arr1[j]>arr2[i];j--){
	           arr1[j+1] = arr1[j]; 
	       }
	       if(j!=n-2 || last>arr2[i]){
	           arr1[j+1] = arr2[i];
	           arr2[i] = last;
	       }
	       i--;
	    }
    }

}
