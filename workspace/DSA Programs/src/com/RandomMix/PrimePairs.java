package PractiseJavaPrograms;

public class PrimePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrp = findAllPrimesLessThanNum(29);
	
		printArray(arrp);
		getPrimePairs(arrp,8);
	}
	static void getPrimePairs(int[] arr,int num){
	     outer:
	     for(int i=0;i<arr.length;i++){
	         int p = arr[i];
	         //System.out.println("p "+p);
	         int j=0;
	         inner:
	         while(j<arr.length && arr[j] !=0 && p!=0){
	        	 //System.out.println("j "+j+" arr[j] "+arr[j]);
	           if(p*arr[j]>num){
	               break inner;
	           }
	           System.out.print(p+" "+arr[j]+" ");
	           j++;
	         }
	     }
	 }
	 static int[] findAllPrimesLessThanNum(int num){
	     boolean[] prime = new boolean[num+1];
	     for(int j=0;j<num;j++){// include <= for inclusive num
	         prime[j] = true;
	     }
	     for(int i=2;i*i<=num;i++){
	         if(prime[i] == true){
	            for(int p=i*i;p<=num;p+=i){
	                prime[p] =false;
	            } 
	         }
	     }
	     int[] primeA = new int[num];
	     int i=0;
	     for(int j=2;j<=num;j++){
	         if(prime[j]){
	             //System.out.println("prime "+j);
	             primeA[i] = j;
	             i++;
	         }
	     }
	     return primeA;
	     }
	static void printArray(int arr[]) 
   { 
       int n = arr.length; 
       for (int i=0; i<n; ++i) 
           System.out.print(arr[i] + " "); 
       System.out.println(); 
   } 
}
