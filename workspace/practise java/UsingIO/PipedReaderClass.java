package UsingIO;
import java.io.*;
/**
 * The PipedWriter class is used to write java pipe as a stream of characters. 
 * This class is used generally for writing text. 
 * Generally PipedWriter is connected to a PipedReader and used by different threads
 * @author harshsharma3
 *
 */
public class PipedReaderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try{
    	  final PipedReader read = new PipedReader();  
          final PipedWriter write = new PipedWriter(read);  
          Thread readerThread = new Thread(new Runnable() {  
              public void run() {  
                  try {  
                	  System.out.println("Threa reading "+Thread.currentThread().getName());
                      int data = read.read();  
                      while (data != -1) {  
                          System.out.print((char) data);  
                          data = read.read();  
                      }  
                      write.close();
                  } catch (Exception ex) {  
                  }  
              }  
          });
          Thread writerThread = new Thread(new Runnable() {  
              public void run() {  
                  try {  
                	  System.out.println("Threa writing "+Thread.currentThread().getName());
                      write.write("I love my country\n".toCharArray());  
                  } catch (Exception ex) {  
                  }  
              }  
          });  
          readerThread.start();  
          writerThread.start();  
       
      }catch(Exception e){
    	  e.getMessage();
      }
	}

}
