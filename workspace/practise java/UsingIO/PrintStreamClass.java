package UsingIO;
import java.io.*;
public class PrintStreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		FileOutputStream fout=new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
		PrintStream pout = new PrintStream(fout);
		pout.println("new addition");
		pout.println("lets see if it replaces");
		pout.close();
		fout.close();
	}catch(Exception e){}
}
}