package CollectionsInJava;

import java.util.ArrayList;

interface FuncInterface{
	 // An abstract function 
    void abstractFun(int x); 
  
    // A non-abstract (or default) function 
    default void normalFun() 
    { 
       System.out.println("Hello"); 
    } 
}
public class LambdaExpJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncInterface fi = (int x) -> System.out.println(x*x);
		
		fi.abstractFun(45);
		 // Creating an ArrayList with elements 
        // {1, 2, 3, 4} 
        ArrayList<Integer> arrL = new ArrayList<Integer>(); 
        arrL.add(1); 
        arrL.add(2); 
        arrL.add(3); 
        arrL.add(4); 
        
        arrL.forEach((n) -> {
        	if(n%2==0) System.out.println(n);
        });
		
	}

}
