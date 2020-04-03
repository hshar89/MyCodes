package UsingIO;
import java.io.Console;
public class ConsoleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Console cs = System.console();
   if(cs == null)  
   { 
       System.out.print("No console available"); 
       return; 
   } 
   System.out.println("Enter your name: ");
   String name = cs.readLine();
   System.out.println("Hello: "+name);
   System.out.println("Enter password: ");    
   char[] ch=cs.readPassword();    
   String pass=String.valueOf(ch);//converting char array into string    
   System.out.println("Password is: "+pass);    
	}

}
