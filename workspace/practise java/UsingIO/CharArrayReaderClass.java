package UsingIO;
import java.io.CharArrayReader;  
public class CharArrayReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		 char[] ary = { 'j', 'a', 'v', 'a', 't', 'p', 'o', 'i', 'n', 't' };  
		    CharArrayReader reader = new CharArrayReader(ary);  
		    int k = 0;  
		    // Read until the end of a file  
		    while ((k = reader.read()) != -1) {  
		      char ch = (char) k;  
		      System.out.print(ch + " : ");  
		      System.out.println(k);  
		    }  
		  }catch(Exception e){}
	}

}
