package CollectionsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Student 
{ 
    int rollno; 
    String name, address; 
  
    // Constructor 
    public Student(int rollno, String name, 
                               String address) 
    { 
        this.rollno = rollno; 
        this.name = name; 
        this.address = address; 
    } 
  
    // Used to print student details in main() 
    public String toString() 
    { 
        return this.rollno + " " + this.name + 
                           " " + this.address; 
    } 
} 

class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return a.rollno - b.rollno; 
    } 
} 

public class ReverseOrderMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a list of Integers 
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        al.add(30); 
        al.add(20); 
        al.add(10); 
        al.add(40); 
        al.add(50); 
  
        /* Collections.sort method is sorting the 
        elements of ArrayList in descending order. */
        Collections.sort(al, Collections.reverseOrder()); 
  
        // Let us print the sorted list 
        System.out.println("List after the use of Collection.reverseOrder()"+ 
                           " and Collections.sort() :\n" + al); 
        
     // Create an array to be sorted in descending order. 
        Integer [] arr = {30, 20, 40, 10}; 
  
        /* Collections.sort method is sorting the 
        elements of arr[] in descending order. */
        Arrays.sort(arr, Collections.reverseOrder()); 
  
        // Let us print the sorted array 
        System.out.println("Array after the use of Collection.reverseOrder()"+ 
                           " and Arrays.sort() :\n" + Arrays.toString(arr)); 
        
        ArrayList<Student> ar = new ArrayList<Student>(); 
        ar.add(new Student(111, "bbbb", "london")); 
        ar.add(new Student(131, "aaaa", "nyc")); 
        ar.add(new Student(121, "cccc", "jaipur")); 
        
        System.out.println("Unsorted"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
        
        Comparator c = Collections.reverseOrder(new Sortbyroll());
        Collections.sort(ar,c);
        
        System.out.println("\nSorted by rollno"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
} 

	}

