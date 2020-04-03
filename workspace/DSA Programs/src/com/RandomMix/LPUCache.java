package PractiseJavaPrograms;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LPUCache {
	 Map<Integer,Integer> map;
	 Deque<Integer> dq;
	    int capacity;
	    /*Inititalize an LRU cache with size N */
	public LPUCache(int N) {
	   //Your code here
	   map = new HashMap<Integer,Integer>();
	   capacity = N;
	   dq = new LinkedList<Integer>();
	}
	 public static void display(Deque<Integer> dq1) 
	    { 
	        Iterator<Integer> itr = dq1.iterator(); 
	        while (itr.hasNext()) { 
	            System.out.print(itr.next() + " "); 
	        } 
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stud
		
     String a = "SET 94 16 SET 93 87 SET 63 22 SET 60 91 SET 41 27 GET 73 GET 12 GET 68 SET 31 83 GET 24 SET 30 36 GET 23 GET 70 SET 57 94 SET 30 43 SET 20 22 GET 38 GET 25 SET 14 71 GET 92 GET 57 SET 71 63 GET 82 SET 85 26 SET 6 37 GET 30 SET 25 58 SET 46 83 GET 68 GET 65 SET 88 51 GET 77 GET 89 GET 4 SET 100 55 GET 61 GET 69 SET 27 13 GET 95 SET 71 96 GET 79 SET 98 2 GET 18 GET 53 GET 2 GET 87 SET 90 66 GET 20 GET 30 SET 98 18 SET 76 82 SET 68 28 GET 98 SET 66 87 GET 84 SET 29 25 SET 30 33 SET 71 20 GET 9 SET 50 41 GET 24 GET 46 GET 52 SET 80 56 GET 65 GET 42 GET 94 GET 35 GET 25 GET 88 GET 44 SET 66 28 SET 33 37 SET 29 38 SET 75 8 SET 96 59 SET 36 38 SET 29 19 SET 29 12 SET 5 77 SET 14 64 GET 7 GET 5 GET 29 GET 70 SET 97 18 GET 44";
     int n = 7;
     a = "GET 45 GET 21 GET 19 SET 100 95 GET 47 GET 54 GET 4 GET 43 GET 35 SET 35 11 SET 16 97 GET 97 GET 83 SET 17 52 SET 38 44 SET 3 62 SET 89 61 SET 42 21 SET 29 25 SET 63 9 GET 71 GET 64 GET 12 GET 16 SET 33 35 GET 51 SET 40 34 GET 95 SET 55 14 GET 45 SET 39 24 SET 74 52 SET 69 66 SET 84 14 SET 36 78 GET 65 SET 8 47 GET 92 GET 12 SET 58 88 GET 94 SET 21 82 GET 72 SET 97 19 GET 84 GET 68 SET 68 1 GET 36 SET 58 91 GET 50 SET 91 24 GET 48 SET 36 50 GET 41 GET 44 SET 67 40 SET 54 37 GET 53 GET 58 GET 88 SET 22 41 GET 98 SET 79 28 GET 70 GET 28 GET 21 SET 61 22 SET 68 17 SET 93 83 SET 54 36 SET 63 9 GET 96 GET 61 GET 77 SET 4 74 SET 74 55";
     LPUCache cg = new LPUCache(n);
     String aa[] = a.split("\\s+");
     int b = 0;
     while(b<aa.length){
    	// System.out.println("aa value "+aa[b]);
    	 if(aa[b].equals("SET")){
    		 //System.out.println("found set");
    		 int a1 = Integer.parseInt(aa[++b]);
    		 int a2 = Integer.parseInt(aa[++b]);
    		 cg.set(a1, a2);
    		
    	 }else if(aa[b].equals("GET")){
    		 System.out.print(cg.get(Integer.parseInt(aa[++b]))+" ");  		
    	 }
    	 b++;
     }
	}    
	/*Returns the value of the key x if 
	 present else returns -1 */
	public int get(int x) {
		 //Your code here
	      if(map.containsKey(x)){
	        dq.remove(x); 
		    dq.addLast(x);
		    return map.get(x);
		   }
		   return -1;
	}
	
	/*Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		 if(!map.containsKey(x)){
	           if(dq.size() == capacity){
	               map.remove(dq.removeFirst()); 
	           }
	       }else{
	           dq.remove(x); 
		 }
		   map.put(x,y);
		   dq.addLast(x);
	}

}
