package LearningFromGFG;
import java.util.Arrays;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 
public class BinarySearchArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int ar[] = {23,45,34,67,45,12};
         Arrays.sort(ar);
         int key = 45;
         int res = Arrays.binarySearch(ar, key);
         if(res>0){
        	 System.out.println(key + " found at index = " 
                     + res); 
         }else{
        	 System.out.println(key + " Not found"); 
         }
         key = 40; 
         res = Arrays.binarySearch(ar, key); 
         if (res >= 0) 
             System.out.println(key + " found at index = " 
                                                   + res); 
         else
             System.out.println(key + " Not found"); 
         // Java program to demonstrate working of Collections. 
      // binarySearch() 
         List<Integer> al = new ArrayList<Integer>(); 
         al.add(1); 
         al.add(2); 
         al.add(3); 
         al.add(10); 
         al.add(20); 
    
         // 10 is present at index 3. 
         int key1 = 10; 
         int res1 = Collections.binarySearch(al, key1); 
         if (res1 >= 0) 
             System.out.println(key1 + " found at index = " 
                                                  + res1); 
         else
             System.out.println(key1 + " Not found"); 
   
	}

}
