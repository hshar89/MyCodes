package UsingIO;
import java.io.*;
public class WriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try{
    	 Writer w = new FileWriter("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
    	 String content = "Why all my content get overwritten";
    	 w.write(content);
    	 w.close();
    	 System.out.println("Done...");
     }catch(Exception e){
    	 System.out.println(e.getMessage());
     }
	}

}
