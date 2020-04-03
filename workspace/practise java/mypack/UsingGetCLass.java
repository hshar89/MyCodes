package mypack;
import java.lang.reflect.Field; 
import java.lang.reflect.Method;
class Student 
{ 
    private String name; 
    private int roll_No; 
  
    public String getName()  {  return name;   } 
    public void setName(String name) { this.name = name; } 
    public int getRoll_no()  { return roll_No;  } 
    public void setRoll_no(int roll_no) { 
        this.roll_No = roll_no; 
    } 
} 
public class UsingGetCLass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student s1 = new Student();
        Class c1 = s1.getClass();
       System.out.println(c1.getName());
       Method m[] = c1.getDeclaredMethods();
       for (Method method : m) {
           System.out.println(method.getName()); 
       }
       Field f[] = c1.getDeclaredFields();
       for(Field field : f){
    	   System.out.println(field.getName()); 
       }
       
	}

}
