package mypack;
class MyPackClass2{
	private static void display(){
		System.out.print("my pack 2");
	}
   void doSome(){
		display();
	}
}
public class MyPackClass1 {
 public void run(){
	 System.out.print("This is from a new package");
 }
 public static void main(String[] args){
	 MyPackClass2 c1 = new MyPackClass2();
	 c1.doSome();
 }
}
