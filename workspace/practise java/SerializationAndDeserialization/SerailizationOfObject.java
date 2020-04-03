package SerializationAndDeserialization;
import java.io.*;
public class SerailizationOfObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Student s1 = new Student("ramesh",45);
       Student s3 = new Student("Ramu",34);
       try{
       FileOutputStream fout = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout7.txt");
       ObjectOutputStream out=new ObjectOutputStream(fout);  
       out.writeObject(s3);
       out.flush();
       out.close();
       FileInputStream fis = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout6.txt");
       ObjectInputStream in = new ObjectInputStream(fis);
       Student s2 = (Student)in.readObject();
       System.out.println(s2.roll+" "+s2.name); 
       in.close();
       }catch(Exception e){
    	   e.printStackTrace();
       }
	}

}
