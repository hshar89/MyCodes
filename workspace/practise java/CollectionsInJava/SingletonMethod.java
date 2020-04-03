package CollectionsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingletonMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] geekslist = { "1", "2", "4", "2", "1", "2", 
                "3", "1", "3", "4", "3", "3" }; 
		
		ArrayList<String> geekslist1 = new ArrayList(Arrays.asList(geekslist)); 
		System.out.println("Original geeklist1: " + geekslist1);
		geekslist1.remove("1"); 
        System.out.println("geekslist1 after removal of 1 without"
                           + " singleton " + geekslist1); 
        geekslist1.remove("1"); 
        System.out.println("geekslist1 after removal of 1 without"
                           + " singleton " + geekslist1); 
        geekslist1.remove("2"); 
        System.out.println("geekslist1 after removal of 2 without"
                           + " singleton " + geekslist1); 
        
        List<String> geekslist2 = new ArrayList(Arrays.asList(geekslist)); 
        System.out.println("\nOriginal geeklist2: " + geekslist2); 
        geekslist2.removeAll(Collections.singleton("1")); 
        System.out.println("geekslist2 after removal of 1 with "
                           + "singleton:" + geekslist2); 
        
        geekslist2.removeAll(Collections.singleton("4")); 
        System.out.println("geekslist2 after removal of 4 with "
                           + "singleton:" + geekslist2);
		 
	}

}
