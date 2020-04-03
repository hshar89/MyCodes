package LearningFromGFG;

public class InPlaceAlgo {
   public static int rep(int x,int y){
	  // System.out.println("x-- "+x+" y--- "+y);
	   return x;
   }
   public void revArra(int[] arr, int n){
	   for(int i=0;i<(n/2);i++){
		   arr[i] = rep(arr[n-i-1],arr[n-i-1] = arr[i]);
		   System.out.println("arr[i] "+arr[i]+ " arr[n-i-1] "+arr[n-i-1]);
	   }
   }
   public static int calFib(int n){
	   if(n<=1){
		   return n;
	   }
	   return calFib(n-1)+calFib(n-2);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {34,12,89,4,2,4,5,78};
		InPlaceAlgo ipa = new InPlaceAlgo();
        ipa.revArra(arr, arr.length);
        System.out.println("after rev");
        for(int j=0;j<arr.length;j++){
        	System.out.print(arr[j]+" ");
        }
        System.out.println();
      long d1 = System.currentTimeMillis();
      System.out.println(calFib(40));  
      System.out.println("time taken "+(System.currentTimeMillis() - d1));
        
	}

}
