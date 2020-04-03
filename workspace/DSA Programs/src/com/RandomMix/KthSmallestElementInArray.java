package PractiseJavaPrograms;

public class KthSmallestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String ab = "7 10 4 3 20 15";
     String[] abA = ab.split("\\s+");
     int[] arr = new int[abA.length];
     for(int i=0;i<abA.length;i++){
    	 arr[i] = Integer.parseInt(abA[i]);
     }
     int k =2;
     System.out.println(k+"th smallest element is "+KthsmallestElement(arr,0,abA.length-1,k));
 	}
	 static int KthsmallestElement(int[] arr,int l,int r,int k){
	      
	      int pos = partition(arr,l,r);
	      System.out.println("pos "+pos+" l "+l+" r "+r);
	      if(pos-l == k-1){
	         return arr[pos]; 
	      }
	      
	      if(pos-l>k-1){
	          return KthsmallestElement(arr,l,pos-1,k);
	      }
	      
	     return KthsmallestElement(arr,pos+1,r,k-pos+l-1);   
	   }
	 static int partition(int[] arr,int l, int r){
	       int pivot = arr[r],i=l;
	       for(int j=l;j<r;j++){
	           if(arr[j]<=pivot){
	               int temp = arr[j];
	               arr[j] = arr[i];
	               arr[i] = temp;
	               i++;
	           }
	       }
	        int temp = arr[i]; 
	        arr[i] = arr[r]; 
	        arr[r] = temp; 
	        
	        return i;
	   }
}
