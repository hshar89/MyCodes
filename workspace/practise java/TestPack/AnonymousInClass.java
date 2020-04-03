package TestPack;
abstract class Person{
	abstract void eat();
}
interface anon{
	void gain();
	int sum(int a,int b);
}
public class AnonymousInClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Person p1 = new Person(){
    	 void eat(){
    		 System.out.println("From frist instance");
    	 }
     };
     p1.eat();
     Person p2 = new Person(){
    	 void eat(){
    		 System.out.println("From second instance"); 
    	 }
     };
     p2.eat();
     anon a1 = new anon(){
    	 public void gain(){
    		 System.out.println("u can have interface also");
    	 }
    	 public int sum(int a, int b){
    		 return a+b;
    	 }
     };
     a1.gain();
     System.out.println("the sum by interface"+a1.sum(23, 67));
	}
	

}
