package PractiseJavaPrograms;

public class CountInversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     long[] arr = {2,4,1,3,5};
     System.out.println("count "+inversionCount(arr,arr.length));
	}
	static long inversionCount(long arr[], long n)
    {
        // add your code here
        long[] temp = new long[(int)n];
        return mergeSort(arr,temp,0,(int)n-1);
    }
	static long mergeSort(long[] arr,long[] temp,int l, int r){
        int mid;
        long inv_count = 0; 
        if(l<r){
           mid = l+(r-l)/2;
           inv_count=mergeSort(arr,temp,l,mid);
           inv_count+=mergeSort(arr,temp,mid+1,r);
          inv_count+= merge(arr,temp,l,mid+1,r);
        }
        return inv_count;
    }
	 static long merge(long[] arr,long[] temp,int l, int mid, int r){
		 System.out.println("low "+l+" mid "+mid+" r "+r);
	        int i,j,k;
	        long inv_count=0;
	        i=l;
	        j=mid;
	        k=l;
	        while(i<=(mid - 1) && (j<=r)){
	        	//System.out.println("arr[i] "+arr[i]+" arr[j] "+arr[j]);
	            if(arr[i]>arr[j]){
	                temp[k++] = arr[j++];
	               // j++;
	                inv_count= inv_count+(mid-i);
	            }else{
	               temp[k++] = arr[i++];
	                i++;
	            }
	        }
	        while(i<=(mid-1)){
	            temp[k++] = arr[i++];
	        }
	        while(j<=r){
	            temp[k++] = arr[j++];
	        }
	        for(int s=l;s<=r;s++){
	            arr[s] = temp[s];
	        }
	        System.out.println("count from merge "+inv_count);
	        return inv_count;
	    }
}
