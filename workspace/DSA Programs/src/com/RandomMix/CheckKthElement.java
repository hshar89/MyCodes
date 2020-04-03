package PractiseJavaPrograms;

import java.util.Arrays;

public class CheckKthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    output(3,3,1);
	}
	 static void output(int a, int b, int k){
		 
	     long power = getPowered(a,b);
	     System.out.println(power);
	     int i=0;
	     long[] arr = new long[100];
	     while(power>0){
	        arr[i] = power%10;
            i++;
            power = power/10;
	     }
	     System.out.println(Arrays.asList(arr));
	     for(int j=0;j<arr.length;j++){
	    	 System.out.print(arr[j]);
	     }
	     System.out.println(arr[k-1]);
	 }
	 static long getPowered(int a, int b){
		 long power = 1l;
		 for(int i=0;i<b;i++){
			 power*=a;
		 }
		 return power;
	 }
}
