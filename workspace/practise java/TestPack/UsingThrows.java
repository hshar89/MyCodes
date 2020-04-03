package TestPack;
import java.io.IOException;
class M{
	void a() throws IOException{
		System.out.println("might throw exp");
		//throw new IOException("throwing from class");
	}
}
public class UsingThrows {
    void m() throws IOException{
    	throw new IOException("device error");
    }
    void n() throws IOException{
    	m();
    }
    void p(){
    	try{
    		n();
    	}catch(Exception e){
    		System.out.println("Exception handled");
    	}
    }
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		UsingThrows ut = new UsingThrows();
		ut.p();
		M m1 = new M();
		m1.a();
		 System.out.println("normal flow...");  
	}

}
