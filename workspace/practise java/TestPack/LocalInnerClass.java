package TestPack;

public class LocalInnerClass {
	private int data = 56;
   void localExperi(){
	   int value =89;
	   class inner{
		   void msg(){
			   System.out.println("messages from class"+value+" "+data);
		   }
	   }
	  inner in1 = new inner();
	  in1.msg();
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LocalInnerClass lic1 = new LocalInnerClass();
         lic1.localExperi();
	}

}
