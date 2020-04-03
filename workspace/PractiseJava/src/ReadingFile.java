import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadingFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\harshsharma3\\Documents\\Notepad++ files\\Enrollment Fields From Manifest.txt"); 		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 		  
		  String st; 
		  List<String> stList = new ArrayList<>();
		  while ((st = br.readLine()) != null) {
			if(!st.isBlank()) {
		    //System.out.println(st);
		    stList.add(st);
			}
		  }
		  Collections.sort(stList);
		  file = new File("C:\\Users\\harshsharma3\\Documents\\Notepad++ files\\Enrollment Fields Permission Set.txt"); 
		  br = new BufferedReader(new FileReader(file)); 		  
		  List<String> stListToCheck = new ArrayList<>();
		  while ((st = br.readLine()) != null) {
			if(!st.isBlank()) {
		    //System.out.println(st);
		    stListToCheck.add(st);
			}
		  }
		  Collections.sort(stListToCheck);
		  boolean found;
		  for(String s: stList) {
			  found = false;
			  for(String x: stListToCheck) {
				  if(x.equalsIgnoreCase(s)) {
					  found = true;
					  break;
				  }
			  }
			  if(!found) {
				  System.out.println(s);
			  }
		  }
     }

}
