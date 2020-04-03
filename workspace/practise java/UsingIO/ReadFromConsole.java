package UsingIO;
import java.io.*;
public class ReadFromConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try{
    	InputStreamReader fis = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(fis);
    	String name = "";
    	while(!name.equals("stop")){
    	System.out.println("Enter your name: ");
    	name = br.readLine();
    	System.out.println("Welcome: "+name);
    	}
    	br.close();
    	fis.close();
      }catch(Exception e){}
	}

}
