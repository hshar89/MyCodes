package UsingIO;
import java.io.*; 
public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {  
	            File file = new File("C:\\Users\\harshsharma3\\Documents\\LearningJava\\javaFile123.txt");  
	            if (file.createNewFile()) {  
	                System.out.println("New File is created!");  
	            } else {  
	                System.out.println("File already exists.");  
	            }  
	        } catch (IOException e) {  
	        	e.printStackTrace();
	            System.out.println(e.getMessage());  
	        }  
	}

}
