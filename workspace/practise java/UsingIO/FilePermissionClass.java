package UsingIO;
import java.io.*;
import java.security.PermissionCollection;
public class FilePermissionClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 String srg = "C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt";
		 FilePermission fp1 = new FilePermission("C:\\Users\\harshsharma3\\Documents\\LearningJava\\-","read");
		 PermissionCollection pc = fp1.newPermissionCollection();
		 pc.add(fp1);
		 FilePermission file2 = new FilePermission(srg, "write");
		 pc.add(file2);
		 if(pc.implies(new FilePermission(srg, "read,write"))) {  
             System.out.println("Read, Write permission is granted for the path "+srg );  
             }else {  
            System.out.println("No Read, Write permission is granted for the path "+srg);            
            }  
       }   
	}

