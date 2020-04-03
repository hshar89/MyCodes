package UsingIO;
import java.io.CharArrayWriter;  
import java.io.FileWriter;
public class CharArrayWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		  CharArrayWriter out=new CharArrayWriter();    
          out.write("Welcome to javaTpoint");    
          FileWriter f1=new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");    
          FileWriter f2=new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout.txt"); 
          out.writeTo(f1);
          out.writeTo(f2);
          f1.close();
          f2.close();
          System.out.println("Success...");   
	}catch(Exception e){}
	}
}
