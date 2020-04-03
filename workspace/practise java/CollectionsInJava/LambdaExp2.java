package CollectionsInJava;

import java.util.Arrays;

interface interf1{
	int operation(int x, int y);
}
interface interf2{
	void sayMessage(String mes);
}

public class LambdaExp2 {
	private int operate(int a, int b, interf1 obj){
		return obj.operation(a,b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       interf1 add = (int x,int y) -> x+y;
       interf1 multiply = (int x,int y)->x*y;
       
       LambdaExp2 tobj = new LambdaExp2();
       System.out.println("Addition is " + 
               tobj.operate(6, 3, add)); 
    // Multiply two numbers using lambda expression 
       System.out.println("Multiplication is " + 
                         tobj.operate(6, 3, multiply));
       interf2 fobj = message ->System.out.println("Hello "
               + message); 
        fobj.sayMessage("Geek"); 
	}

}
