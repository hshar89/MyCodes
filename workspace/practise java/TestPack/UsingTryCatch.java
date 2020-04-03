package TestPack;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class UsingTryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     PrintWriter pw;
     try{
    	 pw = new PrintWriter("jtp.txt");
    	 pw.print("saved");
     }catch(FileNotFoundException e){
    	 System.out.println(e.getMessage());
     }
     System.out.println("File saved successfully");
	}

}
