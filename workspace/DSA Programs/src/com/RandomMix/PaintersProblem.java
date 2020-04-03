package PractiseJavaPrograms;

public class PaintersProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, 60, 50, 30, 40};//30, 40 
		   
	    // Calculate size of array. 
	    int n = arr.length; 
	        int k = 2; 
	 System.out.println(partition(arr, n, k));
	 System.out.println("this is through binary search ");
	 System.out.println(getMostWork(arr,n,k));
	}
	public static int partition(int[] arr, int n, int k){
		//System.out.println("n "+n+" k "+k);
		if(k==1){
			return sum(arr,0,n-1);
		}
		if(n==1){
			return arr[0];
		}
		int best  = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++){
			best = Math.min(best,Math.max(partition(arr,i,k-1), sum(arr,i,n-1)));
			//System.out.println("i "+i+" best "+best);
		}
		
		return best;
	}
	public static int sum(int[] arr, int s, int e){
		int sumA = 0;
		for(int i=s;i<=e;i++){
			sumA+=arr[i];
		}
		return sumA;
	}
	public static int getMostWork(int[] arr, int n, int k){
		int lo = getMaxMemberInArray(arr,n);
		System.out.println("low " +lo);
		int high = sum(arr,0,n-1);
		System.out.println("high " +high);
		while(lo<=high){
			int mid = (lo+high)/2;
			System.out.println("mid " +mid);
			int noOfstudents = getWorkersRequired(arr,n,mid);
			System.out.println("no of studens "+noOfstudents);
			if(noOfstudents<=k){
				high = mid-1;
			}else{
				lo = mid+1;
			}
		}
		return lo;
	}
	public static int getWorkersRequired(int[] arr, int n, int mid){
		int totalBook = 0,noOfstudents = 1;
		for(int i=0;i<n;i++){
			if(totalBook+arr[i]>mid){
				totalBook = arr[i];
				noOfstudents++;
			}else{
				totalBook+=arr[i];
			}
		}
		return noOfstudents;
	}
	public static int getMaxMemberInArray(int[] arr, int n){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		return max;
	}

}
