package UsingIO;
import java.io.*;
public class PushBackInputStreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		String srg = "1##2#34###12";  
        byte ary[] = srg.getBytes(); 
        ByteArrayInputStream array = new ByteArrayInputStream(ary); 
        PushbackInputStream push = new PushbackInputStream(array);
        int i;
        String s = "#";
        char cr = s.charAt(0);
        while((i= push.read())!= -1){
        	if((char)i==cr){
        		int j = push.read();
        		if((char)j == cr){
        		System.out.print("**");	
        		}else{
        			push.unread(j);
        			System.out.print((char)i);
        		}
        	}else{
        		System.out.print((char)i);
        	}
        }
	}catch(Exception e){}
	}
}
