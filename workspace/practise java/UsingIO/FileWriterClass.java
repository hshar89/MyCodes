package UsingIO;
import java.io.*;
public class FileWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
      FileWriter fw = new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
      fw.write("This is a new update take it seriously");
      fw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
