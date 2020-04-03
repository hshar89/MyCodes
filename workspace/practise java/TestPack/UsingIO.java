package TestPack;

public class UsingIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.err.println("this is error");
        try{
        int i = System.in.read();
        System.out.println("char"+(int)i);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
	}

}
