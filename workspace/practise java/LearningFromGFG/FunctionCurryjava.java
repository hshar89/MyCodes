package LearningFromGFG;

import java.util.function.Function;
public class FunctionCurryjava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Using Java 8 Functions 
        // to create lambda expressions for functions 
        // and with this, applying Function Currying 
      Function<Integer,Function<Integer,Function<Integer,Integer>>>
      triAdder = u -> v -> z -> u+v+z;
   // Calling the curried functions 
      
      // Calling Curried Function for Adding u, v & w 
      System.out.println(triAdder.apply(67).apply(45).apply(23));
      
      Function<Integer,Function<Integer,Integer>>
      doubleMultiplier = u -> w -> u*w;
      System.out.println(doubleMultiplier.apply(34).apply(23));
	}

}
	