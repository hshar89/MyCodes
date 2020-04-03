package TestPack;

public class JustTesting {
   public static void badMethod(){
	   throw new Error();
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
    	   badMethod();
    	   System.out.println("a");
       }catch(Exception e){
    	   System.out.println("B");
       }
       finally{
    	   System.out.println("C");
       }
       System.out.print("Code continues ...");
	}

}
