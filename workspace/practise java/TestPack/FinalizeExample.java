package TestPack;

public class FinalizeExample {
	public void finalize(){System.out.println("finalize called");}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalizeExample f1=new FinalizeExample();  
		FinalizeExample f2=new FinalizeExample();  
		f1=null;  
		f2=null;  
		System.gc();  
	}

}
