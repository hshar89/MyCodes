package UsingIO;
import java.io.*;
public class FileDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String path = "";  
	        boolean bool = false;  
	        try{
	        	File f1 = new File("C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout4.txt");
	        	f1.createNewFile();
	        	System.out.println(f1);
	        	 File file2 = f1.getCanonicalFile(); 
	        	 System.out.println(file2); 
	        	 bool = file2.exists();  
	        	 // returns absolute pathname  
	             path = file2.getAbsolutePath();
	             System.out.println(bool);  
	             // if file exists  
	             if (bool) {  
	                 // prints  
	                 System.out.print(path + " Exists? " + bool);  
	             }  
	             File file3 = new File("C:\\Users\\harshsharma3\\Documents\\LearningJava");
	             String[] fileNames = file3.list();
	             for(String fname: fileNames){
	            	 System.out.println(fname);
	             }
	             File[] file4 = file3.listFiles();
	             for(File file: file4){
	            	 System.out.println("File name "+file.getName()+"Can write: "+file.canWrite()+"Is hidden: "+file.isHidden()+"length: "+file.length());
	             }
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	}

}
