package LearningFromGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; 
public class SortingInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ArrayList<String> al = new ArrayList<String>();
    al.add("Geeks For Geeks"); 
    al.add("Friends"); 
    al.add("Dear"); 
    al.add("Is"); 
    al.add("Superb"); 
    
    /* Collections.sort method is sorting the 
    elements of ArrayList in ascending order. */
    Collections.sort(al); 
    /* Collections.sort method is sorting the 
    elements of ArrayList in ascending order. */
    System.out.println("List after the use of" + 
            " Collection.sort() :\n" + al); 
    Collections.sort(al, Collections.reverseOrder());
    System.out.println("List after the use of" + 
            " Collection.sort() :\n" + al); 
    
    int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 }; 
    
    Arrays.sort(arr); 

    System.out.printf("Modified arr[] : %s", 
                      Arrays.toString(arr)); 
    // Sort subarray from index 1 to 4, i.e., 
    // only sort subarray {7, 6, 45, 21} and 
    // keep other elements as it is. 
    Arrays.sort(arr, 1, 5); 

    System.out.printf("Modified arr[] : %s", 
                      Arrays.toString(arr)); 
    
	}

}
