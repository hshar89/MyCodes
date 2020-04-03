package TestPack;

public class UsingThrow {
	 static void validate(int age){  
		 try{
			 if(age<18)  
	      throw new ArithmeticException("not valid");  
	     else  
	      System.out.println("welcome to vote"); 
		 }catch(Exception e){
			 System.out.println("msg "+e.getMessage());
		 }
	   }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validate(13);  
	      System.out.println("rest of the code...");  
	}

}
