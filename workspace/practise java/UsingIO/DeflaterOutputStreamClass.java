package UsingIO;
import java.io.*;
import java.util.zip.*;
public class DeflaterOutputStreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		FileInputStream fin=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");  
		FileOutputStream fout=new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout5.txt");
		DeflaterOutputStream out=new DeflaterOutputStream(fout); 
		int i;
		while((i=fin.read())!=-1){
			out.write((byte)i);
			out.flush();
		}
		fin.close();
		out.close();
		FileInputStream fis=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout5.txt");
		File f = new File("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout6.txt");
		f.createNewFile();
		FileOutputStream fout2=new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout6.txt");
		InflaterInputStream in=new InflaterInputStream(fis); 
		int j;
		while((j=in.read())!=-1){
			fout2.write((char)j);
			fout2.flush();
		}
		fis.close();
		in.close();
		fout2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
