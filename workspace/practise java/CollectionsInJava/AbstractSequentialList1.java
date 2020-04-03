package CollectionsInJava;

import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class AbstractSequentialList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AbstractSequentialList<Integer> 
         absl = new LinkedList<>(); 
		  // adding elements to absl 
	        absl.add(5); 
	        absl.add(6); 
	        absl.add(7); 
	  
	        // Printing the list 
	        System.out.println(absl); 
	        
	        AbstractSequentialList<String> 
            absqlist = new LinkedList<String>(); 
  
        // Using add() method to add elements in the list 
        absqlist.add("Geeks"); 
        absqlist.add("for"); 
        absqlist.add("Geeks"); 
        absqlist.add("10"); 
        absqlist.add("20"); 
  
        // Output the list 
        System.out.println("AbstractSequentialList: "
                           + absqlist); 
  
        // Remove the head using remove() 
        absqlist.remove(3); 
  
        // Print the final list 
        System.out.println("Final List: "
                           + absqlist); 
  
        // Fetching the specific element from the list 
        // using get() method 
        System.out.println("The element is: "
                           + absqlist.get(2));     
	}

}
