package CollectionsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IterableToCollection {
	
	public static <T> Collection <T> getCollectionFromIteralbe(Iterable <T> itr){
		Collection<T> coln = new ArrayList<T>();
		for(T t:itr){
			coln.add(t);
		}
		return coln;
	}
   public static <T> Collection <T> getCollectionFromIterable2(Iterable<T> itr){
	   Collection<T> coln = new ArrayList<T>();
	   itr.forEach(coln::add);
	   return coln;
   }
   public static <T>Collection<T> getCollectionFromIterable3(Iterable<T> itr){
	   Collection<T> coln = new ArrayList<T>();
	   Iterator<T> test = itr.iterator();
	   while(test.hasNext()){
		   coln.add(test.next());
	   }
	   return coln;
   }
   public static <T> Collection<T> getCollectionFromIterable4(Iterable<T> itr){
	   Collection<T> coln = new ArrayList<T>();
	   return StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList());
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Iterable<Integer> ar= Arrays.asList(1,2,3,4,5);
        System.out.println("Iterable List : " + ar);
        
        Collection<Integer> cn = getCollectionFromIteralbe(ar);        
        System.out.println("Collection List : " + cn); 
        
        Collection<Integer> cn2 = getCollectionFromIterable2(ar);       
        System.out.println("Collection List from forEach : " + cn2); 
        
        Collection<Integer> cn3 = getCollectionFromIterable3(ar);        
        System.out.println("Collection List from Iterator : " + cn3);
        
        Collection<Integer> cn4 = getCollectionFromIterable4(ar);       
        System.out.println("Collection List from Stream support : " + cn4); 
	}

}
