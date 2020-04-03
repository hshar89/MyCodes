package CollectionsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Integer[] arr= {34,56,21,30,67};
       System.out.println("Original Array : " + 
               Arrays.toString(arr)); 
       Collections.rotate(Arrays.asList(arr), 3);
       System.out.println("aftr rotating "+Arrays.toString(arr));
       
       // Let us create a list of strings 
       List<String>  mylist = new ArrayList<String>(); 
       mylist.add("practice"); 
       mylist.add("code"); 
       mylist.add("quiz"); 
       mylist.add("geeksforgeeks"); 
  
       System.out.println("Original List : " + mylist); 
  
       // Here we are using rotate() method 
       // to rotate the element by distance 2 
       Collections.rotate(mylist, 2); 
  
       System.out.println("Rotated List: " + mylist); 
	}

}
