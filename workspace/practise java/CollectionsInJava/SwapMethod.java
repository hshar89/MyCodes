package CollectionsInJava;

import java.util.ArrayList;
import java.util.Collections;

public class SwapMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Let us create a list with 4 items 
        ArrayList<String>  mylist = 
                        new ArrayList<String>(); 
        mylist.add("code"); 
        mylist.add("practice"); 
        mylist.add("quiz"); 
        mylist.add("geeksforgeeks"); 
  
        System.out.println("Original List : \n" + mylist);
        
        Collections.swap(mylist, 1, 3);
        
        System.out.println("\nAfter swap(mylist, 1, 3) : \n"
                + mylist); 
	}

}
