package PractiseJavaPrograms;

public class AmorphicNon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String snum ="25";
       int number = Integer.parseInt(snum);
		
		 int square = number*number;
		 checkAutomorphic(square,snum);
	}
	static void checkAutomorphic(int num, String oriNum){
	    int i=0;
	    int sum =0;
	    while(i<oriNum.length() && num>0){
	        sum += (num%10)*(Math.pow(10, i));
	        num = num/10;
	        i++;
	    }
	   if(oriNum.equals(String.valueOf(sum))){
	       System.out.println("Automorphic");
	   }else{
	       System.out.println("Not Automorphic");
	   } 
	} 
}
