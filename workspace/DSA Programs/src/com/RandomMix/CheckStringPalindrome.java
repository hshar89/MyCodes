package PractiseJavaPrograms;

public class CheckStringPalindrome {
    static String getRev(String str){
    	String strRev="";
    	for(int i=str.length()-1;i>=0;i--){
    		strRev += str.charAt(i);
    	}
    	return strRev;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String input = "Jatin";
       String revInput = getRev(input);
       if(input.equalsIgnoreCase(revInput)){
    	   System.out.println("yes palindrome");
       }else{
    	   System.out.println("Not palindrome");
       }
	}

}
