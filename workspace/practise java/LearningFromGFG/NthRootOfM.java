package LearningFromGFG;

public class NthRootOfM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNthRootOfM(2,4);
	}
	 static void findNthRootOfM(int n, int m){
		 double d1 = Math.pow(m,(1.0/n));
		 System.out.println("double d1 "+d1);
	     String d = String.valueOf(Math.pow(m,(1.0/n)));
	     System.out.println("String "+d);	
	    
	     String[] arrS = d.split("\\.");
	     int endIndex = arrS[1].length()>1?5:1;
	     String part2 = arrS[1].substring(0, endIndex);
	     if(Long.parseLong(part2)>0 && !part2.contains("99999")){
	    	 System.out.println(-1);
	     }else{
	    	 System.out.println(Integer.valueOf(arrS[0])+1);
	     }
	 }
	 static void printArray(String arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
}
