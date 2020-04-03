package PractiseJavaPrograms;

public class RearrangeArrayLrgeSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void rearrange(int arr[], int n){
	        
	        // Your code here
	    int mid = n%2==0?(n/2)-1:(n/2);
	    int[] arr2 = new int[mid];
	    
	    int place = 0;
	    for(int i=n-1;i>mid;i--){
	        int temp = arr[n-1];
	        for(int j=n-2;j>=place;j--){
	            arr[j+1] = arr[j];
	        }
	        arr[place] = temp;
	        place +=2;
	    }
	    
	}
	 public static void rearrange2(int arr[], int n){
	        
	        // Your code here
	        int mid = n/2;
	        int[] arr2 = new int[mid];
	        int j =0,i=0;
	        for(i=n-1;j<arr2.length;i--){
	            arr2[j] = arr[i];
	            j++;
	        }
	        if(n%2!=0){
	            arr[n-1] = arr[i];
	            i--;
	            j=n-2;
	        }else{
	            j=n-1;
	        }
	        for(;j>0 && i>=0;j-=2){
	            arr[j] = arr[i];
	            i--;
	        }
	        i=0;
	        j=0;
	        while(i<arr2.length){
	            arr[j] = arr2[i];
	            i++;
	            j+=2;
	        }
	        
	    }
}
