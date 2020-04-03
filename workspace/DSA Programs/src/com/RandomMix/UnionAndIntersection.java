package PractiseJavaPrograms;

public class UnionAndIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr1 = {2,2,3,4,5};
       int[] arr2 = {1,1,2,3,4};
       findUnion(arr1,arr2,arr1.length,arr2.length);
	}
	 static void findUnion(int arr1[], int arr2[], int n, int m)
	    {
	        // add your code here
	        int[] temp = new int[n+m];
	        int i=0,j=0,k=0;
	        while(i<n && j<m){
	            if(arr1[i] > arr2[j]){
	                temp[k++] = arr2[j++];
	            }else{
	               temp[k++] = arr1[i++];
	            }
	        }
	        while(i<n){
	            temp[k++] = arr1[i++];
	        }
	        while(j<m){
	            temp[k++] = arr2[j++];
	        }
	        for(i=0;i<(n+m);i++){
	            System.out.print(temp[i]+" ");
	            while(i<(n+m-1) && temp[i+1]==temp[i]){
	                i++;
	            }
	        }
	    }
	 static void findIntersection(int arr1[], int arr2[], int n, int m)
	    {
	        // add your code here
	        int size;
	        if(n>m){
	            size = m;
	        }
	        else{
	            size = n;
	        }
	        int[] temp = new int[size];
	        int i=0,j=0,k=0;
	        while(i<arr1.length && j<arr2.length){
	            if(arr1[i] == arr2[j]){
	                temp[k++] = arr1[i++];
	                j++;
	            }else if(arr1[i]>arr2[j]){
	                j++;
	            }else{
	                i++;
	            }
	        }
	        for(i=0;i<size;i++){
	            if(temp[i]>0)
	            System.out.print(temp[i]+" ");
	        }
	    }
}
