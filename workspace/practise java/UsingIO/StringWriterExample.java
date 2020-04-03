package UsingIO;
import java.io.*; 
/**Java StringWriter class is a character stream that collects output from string buffer,
 *  which can be used to construct a string. 
 * The StringWriter class inherits the Writer class.
 * **/
public class StringWriterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
     char[] arr = new char[512];
     StringWriter writer = new StringWriter(); 
     FileInputStream fis = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
     BufferedReader buffer = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
     int x;
     while((x=buffer.read(arr))!=-1){
    	 writer.write(arr,0,x);
     }
     System.out.print(writer.toString());
     writer.close();
     fis.close();
	}catch(Exception e){}
	}
}
