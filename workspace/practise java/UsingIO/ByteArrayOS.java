package UsingIO;
import java.io.*;
public class ByteArrayOS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{	
      FileOutputStream fos1 = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");
      FileOutputStream fos2 = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\testout.txt");
      
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      bout.write(54);
      bout.writeTo(fos1);
      bout.writeTo(fos2);
      bout.flush();
      bout.close();
      System.out.print("Success....");
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	  
	}

}
