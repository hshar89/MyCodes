package UsingIO;
import java.io.*;
public class FilterOutputStreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
       File f = new File("C:\\Users\\harshsharma3\\Documents\\testout2.txt");
       FileOutputStream fos = new FileOutputStream(f);
       FilterOutputStream fios = new FilterOutputStream(fos);
       String s = "This is updated version of code";
       byte[] ary = s.getBytes();
       fios.write(ary);
       fios.flush();
       fios.close();
       fos.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
