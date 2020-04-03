package UsingIO;
import java.io.*;
public class BufferedReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
FileReader fr = new FileReader("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt");
BufferedReader br = new BufferedReader(fr);
int i;
while((i=br.read())!= -1){
	System.out.print((char) i);
}
br.close();
fr.close();
	}catch(Exception e){}
	}
}
