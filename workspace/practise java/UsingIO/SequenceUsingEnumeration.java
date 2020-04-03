package UsingIO;
import java.awt.Desktop;
import java.io.*;
import java.util.*;
public class SequenceUsingEnumeration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		FileInputStream input1=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout2.txt");    
	    FileInputStream input2=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\testout.txt");
	    FileInputStream input3=new FileInputStream("C:\\Users\\harshsharma3\\Documents\\CombineOut.txt");
	    Vector v=new Vector();    
	    v.add(input1);    
	    v.add(input2);    
	    v.add(input3);    
	    Enumeration e=v.elements();  
	    SequenceInputStream bin=new SequenceInputStream(e);   
	    int i=0;      
	    while((i=bin.read())!=-1){    
	    System.out.print((char)i);    
	    }     
	    bin.close();
	    input1.close();
	    input2.close();
	    input3.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}

}
