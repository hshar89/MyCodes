package PractiseJavaPrograms;

public class FindGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,25,125};
		 findGCD(arr,arr.length);
	}
	 static void findGCD(int[] arr, int n){
	     //Arrays.sort(arr);
	     int smallest = arr[0];
	     int i=smallest;
	     while(i>0){
	         boolean b = true;
	        for(int j=1;j<n;j++){
	          if(arr[j]%i!=0){
	              b =false;
	              break;
	          }  
	        }
	        if(b){
	            System.out.println(i);
	            break;
	        }
	        i--;
	     }
	 }

}
