package TestPack;
class Parent{
	void msg(){
		System.out.println("parent");
	}
}
public class SuperClassException extends Parent{
    void msg() throws ArithmeticException{
    	System.out.println("throwing io excp");
    }
	public static void main(String[] args){
		// TODO Auto-generated method stub
     Parent p = new SuperClassException();
     p.msg();
	}
}
