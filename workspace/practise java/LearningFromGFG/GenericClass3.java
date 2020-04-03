package LearningFromGFG;

public class GenericClass3 {
	 static <T> void genericDisplay (T element) 
	    { 
	        System.out.println(element.getClass().getName() + 
	                           " = " + element); 
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Calling generic method with Integer argument 
        genericDisplay(11); 
   
        // Calling generic method with String argument 
        genericDisplay("GeeksForGeeks"); 
   
        // Calling generic method with double argument 
        genericDisplay(1.0); 
	}

}
