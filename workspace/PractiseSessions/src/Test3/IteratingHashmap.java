package Test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IteratingHashmap {

	public static void main(String[] args) {
		HashMap<String, String> loans = new HashMap<String, String>();
		loans.put("home loan", "Citibank");
		loans.put("personal loan", "Wells Fargo");
		
		for(String s: loans.keySet()) {
			System.out.println(s+" "+loans.get(s));
		}
		Set<String> keys = loans.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" "+loans.get(key));
		}
		Set<Map.Entry<String, String>> entryset = loans.entrySet();
		for(Entry<String, String> e: entryset) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		Set<Map.Entry<String, String>> entrySet1 = loans.entrySet();
		Iterator<Entry<String, String>> entrySetIterator = entrySet1.iterator();
		while (entrySetIterator.hasNext()) {
			   System.out.println("------------------------------------------------");
			   System.out.println("Iterating HashMap in Java using EntrySet and Java iterator");
			   Entry entry = entrySetIterator.next();
			   System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
			}
		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		Iterator<Integer> it1 = li.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
			it1.remove();
		}
		System.out.println("size "+li.size());
		
		String s = "New Found Baby";
		HashMap<String,List<String>> mp = new HashMap<String,List<String>>();
		String[] arr = s.split(" ");
		for(int i=0;i<arr.length;i++) {
			int idx = arr[i].indexOf(" ");
			String s1 = arr[i].substring(0,idx);
			String s2 = arr[i].substring(idx);
			if(mp.containsKey(s1)) {
				mp.get(s1).add(s2);
			}else {
				List<String> lit = new ArrayList<String>();
				lit.add(s2);
				mp.put(s1,lit);
			}
		}
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

	}

}
