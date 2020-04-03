package Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class UsingGenerics {
    
	private static <T> T identical(T source) {
		return source;
	}
	private static <E> void prints(List<E> elements) {
		for(E e: elements) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] star = {"string","man","child"};
		prints(Arrays.asList(star));
		
		UsingGenerics ug = new UsingGenerics();
		
		Holder<Integer> numbers = ug.new Holder(10);
		numbers.add(34);
		numbers.add(89);
		numbers.add(12);
		Holder<String> strings = ug.new Holder(40);
		strings.add("rat");
		strings.add("cat");
			
		Temp<String> tmp1 = new Temp<String>();
		tmp1.add("Rinkiya");
		Temp<Integer> tmp2 = new Temp<Integer>();
		tmp2.add(45);
		System.out.println(tmp1.get());
		System.out.println(tmp2.get());
		Set test1 = new HashSet<String>();
		test1 = new HashSet<Integer>();
		
		Set<?> setOfUnknownTypes = new HashSet<String>();
		setOfUnknownTypes = new LinkedHashSet<Integer>();
		
		Set<? extends Number> setOfAllSubTypesOfnumbers = new HashSet<Integer>();
		
		setOfAllSubTypesOfnumbers = new HashSet<Float>();
		
		Set<? super TreeMap> setOfAllSuperTypesOfTreeMap = new LinkedHashSet<TreeMap>();
		
		setOfAllSuperTypesOfTreeMap = new LinkedHashSet<SortedMap>();
		
		setOfAllSuperTypesOfTreeMap = new HashSet<Map>();
		
		System.out.println("Generics parametrized method "+identical(89));
		
		for(TestNum tn: TestNum.values()) {
			System.out.println(tn);
			System.out.println(tn.color());
		}
		TestNum tn = TestNum.valueOf("TEST1");

	}
	static class Temp<T>{
		T obj;
		void add(T obj) {
			this.obj = obj;
		}
		T get() {
			return obj;
		}
	}
	/**
	 * Generic Holder for holding contents of different object type
	 * Generic in Java eliminates casting required while calling get(index) from client code
	 * @param <T>
	 */
	class Holder<T>{
	    private T[] contents;
	    private int index = 0;
	    @SuppressWarnings("unchecked")
		public Holder(int size){
	        //contents = new T[size]; //compiler error - generic array creation
	        contents = (T[]) new Object[size]; //workaround - casting Object[] to generic Type
	    }
	 
	    public void add(T content){
	        contents[index] = content;
	    }
	 
	    public T get(int index){
	        return contents[index];
	    }
	}
}
