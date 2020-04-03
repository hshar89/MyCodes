package UsingIO;
import java.io.*;
public class BufferedWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
     FileWriter fw = new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
     BufferedWriter bw = new BufferedWriter(fw);
     bw.write("This is even more updated fuck it");
     bw.close();
     fw.close();
     System.out.println("Success");
		}catch(Exception e){}
	}

}
