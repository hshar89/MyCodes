package UsingIO;
import java.io.*;
public class InputStreamReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try  {  
	            InputStream stream = new FileInputStream("file.txt");  
	            Reader reader = new InputStreamReader(stream);  
	            int data = reader.read();  
	            while (data != -1) {  
	                System.out.print((char) data);  
	                data = reader.read();  
	            }  
	            reader.close();
	            stream.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}

}
