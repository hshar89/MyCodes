package LearningFromGFG;
/*
 * we restricted to only of type A and its sub classes, 
 * So it will throw an error for any other type or sub classes.
 */
class Bound <T extends A>{
	T obj;
	public Bound(T obj){
		this.obj = obj;
	}
	public void doRunTest(){
		this.obj.displayClass();
	}
}
class A{
	public void displayClass() 
    { 
        System.out.println("Inside super class A"); 
    } 
}
class B extends A{
	public void displayClass() 
    { 
        System.out.println("Inside sub class B"); 
    } 
}
class C extends A 
{ 
    public void displayClass() 
    { 
        System.out.println("Inside sub class C"); 
    } 
} 
public class BoundsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Bound <C> oC = new Bound<C>(new C());
         oC.doRunTest();
         Bound <B> oB = new Bound<B>(new B());
         oB.doRunTest();
      // similarly passing super class A 
         Bound<A> bea = new Bound<A>(new A()); 
         bea.doRunTest(); 
           
	}

}
