package UsingIO;
import java.io.*;
public class FilterWriterClass extends FilterWriter{
	FilterWriterClass(Writer out){
		super(out);
	}
	public void write(String str) throws IOException{
		super.write(str.toLowerCase());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		FileWriter fw = new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout3.txt");
		FilterWriterClass filterWriter = new FilterWriterClass(fw);  
		 filterWriter.write("I LOVE MY COUNTRY");  
		 filterWriter.close();
		 FileReader fr = new FileReader("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout3.txt");  
         BufferedReader bufferedReader = new BufferedReader(fr);  
         int k;  
         while ((k = bufferedReader.read()) != -1) {  
             System.out.print((char) k);  
         }  
         bufferedReader.close();  
		}catch(Exception e){}
	}

}
