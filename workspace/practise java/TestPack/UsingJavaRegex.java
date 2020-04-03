
package TestPack;
import java.util.regex.*;
import java.util.Scanner;
public class UsingJavaRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Pattern p = Pattern.compile("[a-z&&[def]]");
    Matcher m = p.matcher("moped");
    boolean b = m.matches();
    System.out.println(b);
    System.out.println("Pattern 1---> "+Pattern.matches("[amn]+", "ammzztt"));
    System.out.println("Pattern 2 --- "+Pattern.matches("[a-zA-Z0-9]{6}", "t56Urp6"));
    System.out.println("Pattern 3 --- "+Pattern.matches("[789]{1}[\\d]{9}", "88793447533"));
	Scanner sc = new Scanner(System.in);
	while(true){
		System.out.println("Entr regex patter:");
		Pattern p2 = Pattern.compile(sc.nextLine());
		System.out.println("Enter text:");
		Matcher m1 = p2.matcher(sc.nextLine());
		boolean found = false;
		while(m1.find()){
			System.out.println("I found the text "+m1.group()+" starting at index "+    
	                 m1.start()+" and ending at index "+m1.end());    
	                found = true; 
		}
		if(!found){
			System.out.println("No match found");
		}
	}
	}

}
