package PractiseJavaPrograms;

public class findnCr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cheaterCode(778,116));
	}
	static int cheaterCode(int n, int r){
		int[] arr =new int[r+1];
		arr[0] = 1;
		for(int i=0;i<=n;i++){
			System.out.println(" i "+i+" r "+r);
			 for(int j=Math.min(i,r);j>0;--j){
				 System.out.println(" j "+j);
				 arr[j]=(arr[j]+arr[j-1])%1000000007;
				 System.out.println("arr[j] "+arr[j]);
			 }
		}
		return arr[r];
	}
	 static void calculatenCr(int n, int r){
		 if(r>n){
	         System.out.println(0);
	         return;
	     }else if(n==r || r==0){
	    	System.out.println(1);
	    	return;
	     }
		 /*int den1 =1,den2 =1;
		 if((n-r)>r){
			 den1 = n-r;
			 den2 = r;
		 }else{
			 den1 = r;
			 den2 = n-r;
		 }*/
		 //int[] arr = removeExtraElements(n,den1);
	     long num1 = factorial(n,(n-r));
	     System.out.println("num1 "+num1);
	     //long den1 = factorial((n-r),0);
	     long den2 = factorial(r,0);
	     //System.out.println("den1 "+den1);
	     System.out.println("den2 "+den2);
	     long fact = (num1/den2);
	     System.out.println(fact);
	 }
	 static int[] removeExtraElements(int n, int den1){
		 int[] filteredEle = new int[n-den1];
		 int i=0;
	     while(n>den1){
	    	 filteredEle[i]=n;
	         n--;
	     }
		 return filteredEle;
	 }
	 static long factorial(int num,int limit){
	     if(num ==0){
	         return 1l;
	     }
	     long fact=1l;
	     while(num>limit){
	         fact=(fact*num)%(1000000007);
	         num--;
	     }
	     //System.out.println("fact "+fact);
	     return fact;
	 }
	 static void getnCr(double n,double r){
		 if(r>n){
	         System.out.println(0);
	         return;
	     }else if(n==r || r==0){
	    	System.out.println(1);
	    	return;
	     }
		 double div1=1d,div2=1d;
		 if((n-r)>r){
			 div1 = n-r;
			 div2 = r;
		 }else{
			 div1 = r;
			 div2 = n-r;
		 }
		
		 double multiply = 1.0d;
		 while(n>div1 && div2>0.0d){
				multiply = (multiply * (n/div2))%(Math.pow(10, 9)+7.0d);
				div2--;
				n--;
			}
		 System.out.println("n after first processing "+n);
		 System.out.println(Math.round(multiply));
		 
	 }
	 static void getnCr2(long n,long r){
		 if(r>n){
	         System.out.println(0);
	         return;
	     }else if(n==r || r==0){
	    	System.out.println(1);
	    	return;
	     }
		 long div1=1l,div2=1l;
		 if((n-r)>r){
			 div1 = n-r;
			 div2 = r;
		 }else{
			 div1 = r;
			 div2 = n-r;
		 }
		
		 long multiply = 1l;
		 while(n>div1 && div2>0l){
				multiply = (multiply) * ((n/div2)/(1000000007l));
				div2--;
				n--;
			}
		 System.out.println("n after first processing "+n);
		// System.out.println(multiply.mod(1000000007));
		 
	 }
	 
}
