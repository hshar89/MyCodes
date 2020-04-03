package TestPack;

public class MultipleTryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try{
    	  int a[] = new int[5];
    	  a[4] = 50/0;
    	  System.out.println("value--->"+a[7]);
      }catch(ArithmeticException e){
    	  System.out.print("Cannot divide by zero");
      }catch(ArrayIndexOutOfBoundsException e){
    	  System.out.println(" "+e.getMessage());
      }catch(Exception e){
    	  System.out.println("biggest exception"+e.getMessage());
      }
      
      try{
    	  int ab[]=new int[5];    
    	    ab[5]=30/0;  
      }
      catch(Exception e){System.out.println("common task completed");}    
      System.out.println("rest of the code...");    
	}

}
