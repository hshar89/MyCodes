package TestPack;

public class ExceptionPropogation {
    static void a(){
    	int b = 5/0;
    }
    static void b(){
    	try{
    	a();
    	}catch(Exception e){
    		System.out.println("ye b mei fassa");
    	}
    }
   static void c(){
    	try{
    		b();
    	}catch(ArithmeticException e){
    		System.out.println("yhn fassa");
    	}
    }
   void m(){  
	   throw new ArithmeticException("tu gya");
	   //throw new java.io.IOException("device error");//checked exception  
	  }  
	  void n(){  
		  try{
	    m();  
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
	  }  
	  void p(){  
	   try{  
	    n();  
	   }catch(Exception e){System.out.println("exception handeled");}  
	  }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        c();
        ExceptionPropogation ep = new ExceptionPropogation();
        ep.p();
	}

}
