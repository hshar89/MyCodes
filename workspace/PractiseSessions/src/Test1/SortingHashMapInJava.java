package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortingHashMapInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> mp = new HashMap<Integer,String>();
		mp.put(1, "USA");
		mp.put(4, "Russia");
		mp.put(2, "China");
		mp.put(5, "India");
		mp.put(3, "England");
		Set<Entry<Integer, String>> es = mp.entrySet();
		System.out.println("Before Sorting");
		for(Entry entry: es) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		System.out.println("After sorting by key");
		es = sortByKey(mp).entrySet();
		for(Entry entry: es) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		System.out.println("Sorted by values");
		es = sortByValues(mp).entrySet();
		for(Entry entry: es) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKey(Map<K,V> mp){
		List<K> ll = new LinkedList<>(mp.keySet());
		Collections.sort(ll);
		Map<K,V> sorted = new LinkedHashMap<K,V>();
		for(K k: ll) {
			sorted.put(k, mp.get(k));
		}
		return sorted;
	}
	public static <K extends Comparable, V extends Comparable>Map<K,V> sortByValues(Map<K,V> mp){
		
		List<Entry<K, V>> entries = new LinkedList<Entry<K,V>>(mp.entrySet());
		Collections.sort(entries,new Comparator<Entry<K,V>>(){

			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		Map<K,V> sorted = new LinkedHashMap<K,V>();
		for(Entry<K,V> entry: entries) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}
	

}
