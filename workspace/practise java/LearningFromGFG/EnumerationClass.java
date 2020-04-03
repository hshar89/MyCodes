package LearningFromGFG;
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Vector v = new Vector();
           for(int i=0;i<10;i++){
        	   v.add(i);
           }
           System.out.println("vector"+v);
           Enumeration e = v.elements();
           while(e.hasMoreElements()){
        	   try{
        	   int i=(Integer)e.nextElement();
        	   System.out.print(i + " "); 
        	   }catch(Exception ex){
        		   System.out.println(ex.getMessage());
        	   }
           }
	}

}
