package CollectionsInJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuffleMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>  mylist = new ArrayList<String>(); 
        mylist.add("code"); 
        mylist.add("quiz"); 
        mylist.add("geeksforgeeks"); 
        mylist.add("quiz"); 
        mylist.add("practice"); 
        mylist.add("qa"); 
  
        System.out.println("Original List : \n" + mylist); 
  
        Collections.shuffle(mylist); 
  
        System.out.println("\nShuffled List : \n" + mylist); 
        
        Collections.shuffle(mylist, new Random()); 
        System.out.println("\nShuffled List with Random() : \n"
                                                     + mylist); 
        // Here we use Random(3) to shuffle given list. 
        Collections.shuffle(mylist, new Random(3)); 
        System.out.println("\nShuffled List with Random(3) : \n"
                                                     + mylist);
	}

}
