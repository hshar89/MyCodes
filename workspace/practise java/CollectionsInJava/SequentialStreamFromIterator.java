package CollectionsInJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SequentialStreamFromIterator {
	/*
	 * Spliterator acts as the intermediate while creating 
	 * Sequential Stream from Iterator.
	 * The Iterator is first 
	 * converted to Spliterator with the help of Spliterators.spliteratorUnknownSize(). 
	 */
	public static <T> Stream <T> iteratorToSequentialStream(Iterator itr){
    	Spliterator<T> spitr = Spliterators.spliteratorUnknownSize(itr, Spliterator.NONNULL);
    	 return StreamSupport.stream(spitr, false); 
    }
	/*
	 * source of Spliterator is set to an Iterable created from the Iterator.
       So first the Iterable is created from the Iterator. Then the Spliterator is
       passed to the stream() method directly as Iterable.spliterator().
	 */
	 public static <T> Stream<T>  
		     iteratorToSequentialStream2(Iterator<T> itr) 
		{ 
		// Get an iterable from itr 
		Iterable<T> itb = () -> itr; 
		
		// Get spliterator() from iterable and then 
		// Convert into a sequential stream. 
		// The second parameter "false" passess whether the 
		// stream is to be created parallel or not 
		return StreamSupport.stream(itb.spliterator(), false); 
		} 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iterator<String> iterator = Arrays.asList("G", "E", "E",  
                "K", "S").iterator(); 
		Stream<String> stream = iteratorToSequentialStream(iterator);
		Iterator<String> iterator2 = Arrays.asList("G", "E", "E",  
                "K", "S").iterator(); 
		Stream<String> stream2 = iteratorToSequentialStream2(iterator2); 
		System.out.println("Sequential Stream : " +  
                stream.collect(Collectors.toList()));
		System.out.println("Sequential Stream 2 : " + 
                stream2.collect(Collectors.toList())); 
	}

}
