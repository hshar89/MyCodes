package TestPack;
interface outer_face{
	void repeat();
	interface inner_face{
		void dig();
	}
}
public class NestedInterface implements outer_face.inner_face{
     public void repeat(){
    	 System.out.println("ye implement kiya repeat");
     }
     public void dig(){
    	 System.out.println("digging gold");
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       outer_face.inner_face oi1 = new NestedInterface();
       oi1.dig();
	}

}
