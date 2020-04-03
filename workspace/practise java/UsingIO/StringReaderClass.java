package UsingIO;
import java.io.*;
/**
 * Java StringReader class is a character stream with string as a source. 
 * It takes an input string and changes it into character stream. 
 * It inherits Reader class.
 * @author harsh sharma
 *
 */
public class StringReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
    	   String srg = "Hello Java!! \nWelcome to Javatpoint.";  
           StringReader reader = new StringReader(srg);  
           int k=0;  
               while((k=reader.read())!=-1){  
                   System.out.print((char)k);  
               }  
       }catch(Exception e){}
	}

}
