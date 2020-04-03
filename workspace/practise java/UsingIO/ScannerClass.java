package UsingIO;
import java.util.*;
public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s= "This is sparta";
     Scanner scan = new Scanner(s);
     System.out.println("boolean result :"+scan.hasNext());
   //Print the string  
     System.out.println("String: " +scan.nextLine());  
     scan.close();
     System.out.println("--------Enter Your Details-------- ");
     Scanner scan2 = new Scanner(System.in);
     System.out.print("Enter your name: ");
     String name = scan2.nextLine();
     System.out.println("Name: " + name);           
     System.out.print("Enter your age: ");  
     int age = scan2.nextInt();
     System.out.println("Age: " + age);  
     System.out.print("Enter your salary: ");  
     double salary = scan2.nextDouble();
     System.out.println("Salary: " + salary);   
     scan2.close();
     
     String str = "Hello/This is JavaTpoint/My name is Abhishek.";  
     //Create scanner with the specified String Object  
     Scanner scan3 = new Scanner(str);  
     System.out.println("Boolean Result: "+scan3.hasNextBoolean());  
   //Change the delimiter of this scanner  
     scan3.useDelimiter("/");  
   //Printing the tokenized Strings  
     System.out.println("---Tokenizes String---");   
   while(scan3.hasNext()){  
       System.out.println(scan3.next());  
   }  
	}

}
