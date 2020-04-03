package UsingIO;
import java.awt.Desktop;
import java.io.*;
public class BufferedOStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
        FileOutputStream fout = new FileOutputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");
        BufferedOutputStream sfout = new BufferedOutputStream(fout);
        String s="But for that you need to start coding";    
        byte b[]=s.getBytes(); 
        sfout.write(b);
        sfout.flush();
        sfout.close();
        fout.close();
        System.out.println("Success...");
        //File f = new File("C:\\Users\\harshsharma3\\Documents\\testout.txt");
        //Desktop.getDesktop().open(f);
        FileInputStream fin = new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");
        BufferedInputStream bfin = new BufferedInputStream(fin);
        int i;
        while((i=bfin.read())!=-1){
        	System.out.print((char)i);
        }
        bfin.close();
        fin.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
