package UsingIO;
import java.io.*;
public class ReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try{
    	Reader reader = new FileReader("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
    	int data = reader.read();
    	while(data!=-1){
    		System.out.print((char)data);
    		data = reader.read();
    	}
    	reader.close();
      }catch(Exception e){
    	  System.out.println(e.getMessage());
      }
	}

}
