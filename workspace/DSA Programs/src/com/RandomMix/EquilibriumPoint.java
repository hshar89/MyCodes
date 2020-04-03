package PractiseJavaPrograms;
/**
 * Given an array A of N positive numbers. 
 * The task is to find the position where equilibrium first occurs in the array.
 *  Equilibrium position in an array is a position such that 
 * the sum of elements before it is equal to the sum of elements after it.
 * @author harshsharma3
 *
 */
public class EquilibriumPoint {
	 static int equilibriumPoint(int[] arr,int n){
	     if(n==1){
	         return 1;
	     }
	     int sum = 0;
	     int i=0;
	     while(i<n-1){
	         sum+=arr[i];
	         i++;
	     }
	     int sumBackwards = 0;
	     int j = n-1;
	     while(j>0){	    	
	    	 sumBackwards +=arr[j];
	         sum -= arr[j-1];	         
	         if(sum == sumBackwards){
	             return j;
	         }else if(sumBackwards > sum){
	        	 break;
	         }     
	         j=j-1;
	     }
	    return -1; 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc = "4 42 27 16 28 3 4 5 9 3 31 5 5 29 10 18 35 35 33 19 41 "
				+ "23 8 32 9 5 8 18 35 13 6 7 6 10 11 13 37 2 25 7 28 43";
		String abc2 = "20 17 42 25 32 32 30 32 37 9 2 33 31 17 "
				+ "14 40 9 12 36 21 8 33 6 6 10 37 12 26 21 3";
		int[] arr = new int[42];
		String[] arrS = abc.trim().split("\\s+");
		for(int i=0;i<arrS.length;i++){
			arr[i] = Integer.parseInt(arrS[i]);
		}
		int thatPoint = equilibriumPoint(arr,arr.length);
	      System.out.println(thatPoint);
	}

}
