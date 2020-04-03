package UsingIO;
import java.io.IOException;  
import java.io.RandomAccessFile;  
public class RandomAccessFileExample {
	 static final String FILEPATH ="C:\\Users\\harshsharma3\\Documents\\LearningJava\\testout2.txt";
	private static byte[] readFromFile (String pathName, int position, int size) throws IOException{
		 RandomAccessFile file = new RandomAccessFile(pathName, "r"); 
		 file.seek(position); 
		 byte[] bytes = new byte[size];  
		 file.read(bytes);  
	     file.close();  
	     return bytes;  
	}
	 private static void writeToFile(String filePath, String data, int position)  
	            throws IOException {  
		 RandomAccessFile file = new RandomAccessFile(filePath,"rw");
		 file.seek(position);  
	        file.write(data.getBytes());  
	        file.close(); 	 
	 }
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {  
	            System.out.println(new String(readFromFile(FILEPATH, 0, 250)));  
	            writeToFile(FILEPATH, "I love my country and my people", 31);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}

}
