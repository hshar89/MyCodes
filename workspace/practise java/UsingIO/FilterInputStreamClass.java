package UsingIO;
import java.io.*;
public class FilterInputStreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		 File data = new File("C:\\Users\\harshsharma3\\Documents\\testout2.txt");  
	     FileInputStream  file = new FileInputStream(data);  
	     FilterInputStream filter = new BufferedInputStream(file);  
	     int k =0;  
	        while((k=filter.read())!=-1){  
	            System.out.print((char)k);  
	        }  
	        file.close();  
	        filter.close(); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
