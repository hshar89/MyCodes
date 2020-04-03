package TestPack;
class Parent2{
	void msg() throws Exception{
		System.out.println("might throw exception parent");
	}
}
public class OverriddenException extends Parent2{
    void msg() throws ArithmeticException{
    	throw new ArithmeticException("got you");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
     Parent2 p1 = new OverriddenException();
     p1.msg();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
