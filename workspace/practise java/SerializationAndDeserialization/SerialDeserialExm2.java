package SerializationAndDeserialization;
import java.io.*;

public class SerialDeserialExm2 {
	public static void printdata(Emp object1) 
    {  
        System.out.println("name = " + object1.name); 
        System.out.println("age = " + object1.id); 
        System.out.println("a = " + object1.a); 
        System.out.println("b = " + object1.b); 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Emp object = new Emp("ab", 20, 2, 1000); 
		try{
       FileOutputStream fout1 = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout7.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout1);
		out.writeObject(object);
		out.flush();
		out.close();
		printdata(object); 		  
        // value of static variable changed 
        object.a = 2000; 
        
		FileInputStream fin1 = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout7.txt");
		ObjectInputStream in = new ObjectInputStream 
                (fin1);
		Emp e1 = (Emp)in.readObject();
		in.close();
		fin1.close();
		System.out.println("Object has been deserialized\n"
                + "Data after Deserialization.");
		printdata(e1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
