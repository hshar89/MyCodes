package Test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class TradingSystem {
	
	private static String category ="electronic trading system";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TradingSystem system = null;
		System.out.println(system.category);
		
		Hashtable<Integer,String> ht = new Hashtable<>();
		
		ht.put(1, "test1");
		ht.put(2, "test2");
		ht.put(3, "test3");
		ht.put(4, "test4");
		Set<Entry<Integer,String>> st = ht.entrySet();
		Iterator<Entry<Integer,String>> it = st.iterator();
		
		while(it.hasNext()) {
			Entry<Integer,String> em = it.next();
			System.out.println(em.getKey()+" "+em.getValue());
		}
		List<Integer> ll = new ArrayList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		Iterator<Integer> it2 = ll.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
			it2.remove();
			//ll.add(5);
		}
		System.out.println("Done");
		it2 = ll.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		HashMap<Integer,String> mp = new HashMap<>();
		mp.put(1, "one");
		mp.put(2, "two");
		mp.put(3, "two");
		System.out.println(mp.containsValue("three"));
	}

}
