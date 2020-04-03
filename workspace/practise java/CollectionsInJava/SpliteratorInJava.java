package CollectionsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     List<Integer> al = Arrays.asList(23,3,4,67,12,45,54,13);
     Stream<Integer> s = al.stream();
     Spliterator<Integer> sp = s.spliterator();
     
     System.out.println("estimate size : "+sp.estimateSize());
     
     System.out.println("exact size : "+sp.getExactSizeIfKnown());
     
     System.out.println("has characterstics "+sp.hasCharacteristics(sp.characteristics()));
     
     System.out.println("Content of arraylist :"); 
     sp.forEachRemaining(n->System.out.println(n));
     
  // Obtaining another  Stream to the array list. 
     Stream<Integer> str1 = al.stream(); 
     sp = str1.spliterator(); 
     
     // trySplit() method 
     Spliterator<Integer> splitr2 = sp.trySplit(); 
     
     if(splitr2 !=null){
    	 System.out.println("Output from splitr2: ");
    	 splitr2.forEachRemaining((n) -> System.out.println(n));
     }
     // Now, use the splitr 
     System.out.println("\nOutput from splitr1: "); 
     sp.forEachRemaining((n) -> System.out.println(n));
     
  // Create an array list for doubles. 
     ArrayList<Integer> al1 = new ArrayList<>(); 
           
     // Add values to the array list. 
     al1.add(1); 
     al1.add(2); 
     al1.add(-3); 
     al1.add(-4); 
     al1.add(5); 
     
     Spliterator<Integer> sp2 = al1.spliterator();
     
     System.out.print("Contents of arraylist:\n"); 
     
     while(sp2.tryAdvance((n)->System.out.println(n)));
     System.out.println("is spliterator null "+sp2.estimateSize());
  // Create new list that contains absolute values. 
     ArrayList<Integer> al2 = new ArrayList<>(); 
     sp2 = al1.spliterator();
     while(sp2.tryAdvance((n) -> al2.add(Math.abs(n))));
     
     System.out.print("Absolute values of contents of arraylist:\n"); 
     
     // getting Spliterator object on al2 
     sp2 = al2.spliterator(); 
           
           
     while(sp2.tryAdvance((n) -> System.out.println(n)));
	}

}
