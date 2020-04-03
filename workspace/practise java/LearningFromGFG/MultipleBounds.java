package LearningFromGFG;
/*
 * Java Generics supports multiple bounds also, i.e . 
 * In this case A can be an interface or class. If A is class then B and C should be interfaces. 
 * We can’t have more than one class in multiple bounds.
 */
class Bound2 <T extends Y & X> 
{ 
      
    private T objRef; 
      
    public Bound2(T obj){ 
        this.objRef = obj; 
    } 
      
    public void doRunTest(){ 
        this.objRef.displayClass(); 
    } 
} 
interface X 
{ 
    public void displayClass(); 
} 
class Y implements X 
{ 
    public void displayClass() 
    { 
        System.out.println("Inside super class Y"); 
    } 
} 
public class MultipleBounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //Creating object of sub class A and  
        //passing it to Bound as a type parameter. 
		Bound2<Y> bea = new Bound2<Y>(new Y()); 
        bea.doRunTest(); 
	}

}
