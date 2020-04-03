package CollectionsInJava;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.TreeSet; 
public class AbstractCollection1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         AbstractCollection<Object> ab = new ArrayList<Object>();
      
		ab.add("Welcome");
         ab.add("To");
         ab.add("Eclipse");
         ab.add("Program");
         ab.add(1);
         System.out.println("AbstractCollection: "
                 + ab); 
         // Creating an empty collection 
         AbstractCollection<String> 
             abs1 = new TreeSet<String>(); 
   
         // Use add() method to add 
         // elements into the Collection 
         abs1.add("Welcome"); 
         abs1.add("To"); 
         abs1.add("Geeks"); 
         abs1.add("4"); 
         abs1.add("Geeks"); 
         abs1.add("TreeSet"); 

         // Displaying the Collection 
         System.out.println("AbstractCollection 1: "
                            + abs1); 
         
         AbstractCollection<String> 
         abs2 = new TreeSet<String>(); 
         System.out.println("AbstractCollection 2: "
                 + abs2); 
         // Using addAll() method to Append 
         abs2.addAll(abs1); 
         
         // Displaying the Collection 
         System.out.println("AbstractCollection 2: "
                            + abs2); 
       
         // Clearing the collection 
         // using clear() method 
         abs1.clear(); 
   
         // Check for the empty collection 
         System.out.println("Is the collection empty? "
                            + abs1.isEmpty()); 
	}

}
