package TestPack;

public class MemberInnerClass {
     private int age=89;
     public class Inner{
    	 //private int age=56;
    	 void msg(){
    		 System.out.println(age);
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberInnerClass mic1 = new MemberInnerClass();
		MemberInnerClass.Inner in =  mic1.new Inner();
          in.msg();
	}

}
