package CollectionsInJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * A functional interface is an interface that contains only one abstract method. 
 * They can have only one functionality to exhibit.
 * @FunctionalInterface annotation is used to ensure that the 
 * functional interface can’t have more than one abstract method. 
 * @author harshsharma3
 *
 */
public class FunationInterfaceJava {
	@FunctionalInterface
   interface Square{
	   int calculate(int x);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = 
	            Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
		Predicate<String> pd = (s)->s.startsWith("G");
		
		for(String s: names){
			
			if(pd.test(s)){
				System.out.println(s);
			}
		}
		Square s1 = (int x) -> x*x;
		System.out.println("square : "+s1.calculate(34));
	}

}
