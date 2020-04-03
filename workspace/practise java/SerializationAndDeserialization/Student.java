package SerializationAndDeserialization;
import java.io.Serializable;
public class Student implements Serializable{
      String name;
      int roll;
      public Student(String name, int roll){
    	  this.name = name;
    	  this.roll = roll;
      }

}
