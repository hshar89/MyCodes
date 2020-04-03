package RandomNumbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class RandomNumberGenerator {
    
	private static int min = 1;
	private static int max = 100;
	private static Random random = new Random();
	
	private static void generateArray(int n) {
		for(int i=0;i<n;i++) {
			System.out.print((min+random.nextInt(10000000)%max)+" ");
		}
	}
	private static void generateRandomNumber() { 
		System.out.println((min+random.nextInt(10000000)%max));
	}
	private static void generateRandomPairs(int n) {
		
		for(int i=0;i<n;i++) {
			generateArray(2);
			System.out.println();
		}
		
	}
	private static void callRequiredMethod(String methodName, int n,boolean unique) {
		switch(methodName) {
		case "randomPair":
			if(unique) {
			generateRandomPairsUnique(n);
			}else {
			generateRandomPairs(n);	
			}
			break;
		case "array":
			if(unique) {
			generateArrayUnique(n);
			}else {
			generateArray(n);	
			}
			break;
		case "randomNumber":
			generateRandomNumber();
			break;
		default: 
			System.out.println("No Input");
			break;
		}
	}
	private static void generateArrayUnique(int n) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			set.add(min+random.nextInt(10000000)%max);
		}
		for(Integer i: set) {
			System.out.println(i+" ");
		}
	}
	private static void generateRandomPairsUnique(int n) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		while(map.size()<n) {
			map.put(min+random.nextInt(10000000)%max, min+random.nextInt(10000000)%max);
		}
		
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
	}
	public static void main(String[] args) {
		
      String methodName = "randomPair";
      boolean unique = true;
      callRequiredMethod(methodName,40,unique);
	}

}
