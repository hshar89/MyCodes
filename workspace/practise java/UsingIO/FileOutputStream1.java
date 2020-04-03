package UsingIO;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class FileOutputStream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try{
    	  String s = "Welcome to java";
    	  byte[] b = s.getBytes();
    	  FileOutputStream fout=new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\testout.txt");
    	  fout.write(b);
    	  fout.close();
    	  //Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\harshsharma3\\Documents\\basics.pdf");
    	  //p.waitFor();
    	  System.out.println("success...");
    	  FileInputStream fi = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout.txt");
    	  
    	  int i = 0;
    	  while((i=fi.read())!= -1){
    		System.out.print((char)i);
    	  }
    	  fi.close();
    	  System.out.println((char)i);
      }catch(Exception e){
    	  System.out.println(e.getMessage());
      }
	}

}
