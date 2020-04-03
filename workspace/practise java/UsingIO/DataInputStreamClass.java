package UsingIO;
import java.io.*;
public class DataInputStreamClass {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		 FileInputStream input = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");
		DataInputStream dis = new DataInputStream(input);
		int count = input.available();
		byte[] ary = new byte[count];
		dis.read(ary);
		for(byte by: ary){
			char k = (char)by;
			System.out.print(k);
		}
		dis.close();
		input.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
