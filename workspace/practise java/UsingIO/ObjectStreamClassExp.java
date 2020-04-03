package UsingIO;
import java.io.ObjectStreamClass;  
import java.util.Calendar;  
public class ObjectStreamClassExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{                                //mypack.SmartPhone.class
		ObjectStreamClass osc = ObjectStreamClass.lookup(Number.class); 
		 // get the value field from ObjectStreamClass for integers
		System.out.println("class " + osc.forClass());
        System.out.println("get fields" + osc.getFields());  
     // create a new object stream class for Calendar  
        ObjectStreamClass osc2 = ObjectStreamClass.lookup(String.class);
     // get the Class instance for osc2  
        System.out.println("get value field" + osc2.getField("value"));  
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
