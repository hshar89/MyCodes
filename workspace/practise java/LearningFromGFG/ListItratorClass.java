package LearningFromGFG;
import java.util.ArrayList;
import java.util.ListIterator;
public class ListItratorClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>(); 
        for (int i = 0; i < 10; i++) 
            al.add(i); 
  
        System.out.println(al); 
        ListIterator<Integer> ltr = al.listIterator();
        while(ltr.hasNext()){
        	int i = (Integer)ltr.next(); 
        	  
            // getting even elements one by one 
            System.out.print(i + " "); 
            if(i%2==0){
            	i++;
            	ltr.set(i);
            	ltr.add(i);
            }
        }
        System.out.println(); 
        System.out.println(al);
        outer:
        for (int i = 0; i < 10; i++) { 
            for (int j = 0; j < 10; j++) { 
                if (j == 1) 
                    break outer; 
                System.out.println(" value of j = " + j); 
            } 
        } // end of outer loop
        outer2:  
            for (int i = 0; i < 10; i++) { 
                for (int j = 0; j < 10; j++) { 
                    if (j == 1) 
                        continue outer2; //Similar to just break;
                    System.out.println(" value of j = " + j); 
                } 
            } // end of outer loop 
	}

}
