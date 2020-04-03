package PractiseJavaPrograms;

public class MaxANDPairInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4, 8, 6, 2}; 
	    int n = arr.length; 
	    System.out.println("Maximum AND Value = " +  
	                       maxAND(arr, n)); 
	}
	static int maxAND(int[] arr, int n){
		int res =0,count;
		for(int bit = 31;bit>=0;bit--){
			count = checkBit((res | 1<<bit),arr,n);
			if(count>=0){
				res|=(1<<bit);
			}
		}
		return res;
	}
	static int checkBit(int pattern, int[] arr, int n){
		System.out.println("pattern "+pattern);
		int count = 0;
		for(int i=0;i<n;i++){
			if((pattern & arr[i]) == pattern){
				count++;
			}
		}
		return count;
	}

}
