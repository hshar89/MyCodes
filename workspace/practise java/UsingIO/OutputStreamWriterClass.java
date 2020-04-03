package UsingIO;
import java.io.*;
public class OutputStreamWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {  
	            OutputStream outputStream = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");  
	            Writer outputStreamWriter = new OutputStreamWriter(outputStream);  
	  
	            outputStreamWriter.write("Hello World");  
	  
	            outputStreamWriter.close();  
	        } catch (Exception e) {  
	            e.getMessage();  
	        }  
	}

}
