package UsingIO;
import java.awt.Desktop;
import java.io.*;
public class SequenceInputStream1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileInputStream input1=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");    
	    FileInputStream input2=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout.txt");   
	    SequenceInputStream sis = new SequenceInputStream(input1,input2);
	    FileOutputStream fout = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\CombineOut.txt");
	    int j;
	    while((j=sis.read())!=-1){
	    	fout.write((char)j);
	    }
	    sis.close();
	    input1.close();
	    input2.close();
	    fout.close();
	    File f = new File("C:\\Users\\harshsharma3\\Documents\\CombineOut.txt");
        Desktop.getDesktop().open(f);
	}

}
