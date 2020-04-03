package UsingIO;
import java.io.File;  
import java.io.PrintWriter;
public class PrintWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Data to write on Console using PrintWriter
		try{
      PrintWriter writer = new PrintWriter(System.out);    
      writer.write("Javatpoint provides tutorials of all technology.");        
 writer.flush();  
      writer.close();  
//Data to write in File using PrintWriter       
      PrintWriter writer1 =null;      
         writer1 = new PrintWriter(new File("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt"));  
         writer1.write("Like Java, Spring, Hibernate, Android, PHP etc.");                                                   
                         writer1.flush();  
         writer1.close();  
    }catch(Exception e){}
	}
}