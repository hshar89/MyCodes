package PractiseJavaPrograms;

public class SortedAndRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static boolean sortedRotated(int[] arr, int num){
	 int countDown = 0,countUp = 0,n=num;
     for(int i=0;i<n-1;i++){
         if(arr[i+1]>arr[i]){
             countUp++;
         }else{
             countDown++;
         }
     }
     if((countUp==n-2 && countDown == 1 && arr[0]>arr[n-1]) || 
     (countDown == n-2 && countUp == 1 && arr[n-1]>arr[0])){
         return true;
     }else{
         return false;
     }
	}

}
