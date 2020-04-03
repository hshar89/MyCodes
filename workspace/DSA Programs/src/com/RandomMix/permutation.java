package com.RandomMix;

public class permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {13,9};
		 System.out.println((fact(arr[0])/(fact((arr[0]-arr[1])))));
		 String a1 = "Faltu";
		 String a2 = "farzi";
		 char[] ar1 = a1.toCharArray();
		 char[] ar2 = a2.toCharArray();
		 int i=0,j=0;
		 //boolean a1 = false;
		 while(i<ar1.length && j<ar2.length){
			 if(ar1[i]>ar2[j]){
				System.out.println("ar1 is bigger"); 
				break;
			 }else if(ar2[j]>ar1[i]){
				 System.out.println("ar2 is bigger");
				 break;
			 }
			 i++;
			 j++;
		 }
       System.out.println('a'>'b');
	}
	 public static long fact(int num)
	    {
	        long f=1, i;
	        for(i=1; i<=num; i++)
	        {
	            f = f*i;
	        }
	        return f;
	    }
}
