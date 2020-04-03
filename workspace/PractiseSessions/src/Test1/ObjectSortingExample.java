package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class ObjectSortingExample {
	
	private static int sum(String temp,int... numbers) {
		int total = 0;
		for(int num: numbers) {
			total+=num;
		}
		return total;
	}
	private static <T> T identical(T source) {
		return source;
	}
	public static void main(String[] args) {
		
		ComparatorAndComparable ord1 = new ComparatorAndComparable(101,20000, "Sony");
		ComparatorAndComparable ord2 = new ComparatorAndComparable(102,4000, "Hitachi");
		ComparatorAndComparable ord3 = new ComparatorAndComparable(103,6000, "Philips");
		
		List<ComparatorAndComparable> list = new ArrayList<>();
		list.add(ord1);
		list.add(ord2);
		list.add(ord3);
		
		System.out.println("Unsorted collection "+list);
		
		Collections.sort(list);
		
		System.out.println("Sorted in natural order "+list);
		
		Collections.sort(list,new ComparatorAndComparable.OrderByAmount());
		
		System.out.println("Sorted using comparator amount "+list);
		
		Collections.sort(list,new ComparatorAndComparable.OrderByName());
		
		System.out.println("Sorted using comparator name: "+list);
		
		System.out.println("Using var agrs ....."+sum("i",9,4,5,3,23,4));

	}

}
