package UsingIO;
import java.io.*;
public class FilterReaderClass extends FilterReader {
	public FilterReaderClass(Reader in){
		super(in);
	}
	public int read() throws IOException{
		int x = super.read();
		char blank = ' ';
		if((char)x == blank){
			return ((int) '?');
		}else{
			return x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	 Reader reader = new FileReader("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout3.txt");  
    	 FilterReaderClass fr = new FilterReaderClass(reader); 
    	 int i;
    	 while((i=fr.read())!= -1){
    		 System.out.print((char) i);  
    	 }
    	 fr.close();  
         reader.close();  
    }catch(Exception e){}
	}

}
