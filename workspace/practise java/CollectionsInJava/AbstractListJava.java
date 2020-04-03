package CollectionsInJava;

import java.util.AbstractList;
import java.util.LinkedList;

public class AbstractListJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      AbstractList<String> list = new LinkedList<String>();
      list.add("Geeks"); 
      list.add("for"); 
      list.add("Geeks"); 
      list.add("10"); 
      list.add("20"); 
   // Displaying the AbstractList 
      System.out.println("AbstractList:" + list.set(3, "Glory"));
      System.out.println("AbstractList:" + list);
      
      // Remove the head using remove() 
      list.remove(3); 

      // Print the final list 
      System.out.println("Final AbstractList: " + list); 

      // getting the index of last occurence 
      // using lastIndexOf() method 
      int lastindex = list.lastIndexOf("A"); 

      // printing the Index 
      System.out.println("Last index of A : "
                         + lastindex); 
	}

}
