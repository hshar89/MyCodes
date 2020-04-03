package CollectionsInJava;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
public class IteratorToIterable {
	 // Function to get the Spliterator 
    public static <T> Iterable<T> 
    getIterableFromIterator(Iterator<T> iterator) 
    { 
        return new Iterable<T>() { 
            @Override
            public Iterator<T> iterator() 
            { 
                return iterator; 
            } 
        }; 
    } 
    public static <T> Iterable<T> 
    getIterableFromIterator2(Iterator<T> iterator){
    	return () -> iterator;
    }
    
    public static <T> Iterable<T> 
    getIterableFromIterator3(Iterator<T> iterator) 
    { 
    	return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false)
    	.collect(Collectors.toList());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Iterator<Integer> itr = Arrays.asList(1,3,4,56,5,4).iterator();
	Iterable<Integer> 
      iterable = getIterableFromIterator(itr); 
      // Print the elements of Iterable 
      iterable.forEach(System.out::println); 
      System.out.println("method 2 to convert");
   // Get the Iterator 
      Iterator<Integer> 
          iterator2 = Arrays.asList(1, 2, 3, 4, 5) 
                         .iterator(); 
      Iterable<Integer> iterable2 = getIterableFromIterator2(iterator2);
      iterable2.forEach(System.out::println);
      System.out.println("Method 3");
      // Get the Iterator 
      Iterator<Integer> 
          iterator3 = Arrays.asList(1, 2, 3, 4, 5) 
                         .iterator(); 
      // Get the Iterable from the Iterator 
      Iterable<Integer> 
          iterable3 = getIterableFromIterator(iterator3); 

      // Print the elements of Iterable 
      iterable3.forEach(System.out::println); 
	}

}
