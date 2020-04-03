package TestPack;
/** This class is a user-defined class that contains one methods cube.*/ 
public class DocumentingClass {
	/** The cube method prints cube of the given number */  
	public static void  cube(int n){System.out.println(n*n*n);
	}
	static String useStringMethod(){
		String sb = "Test";
		for(int i=0; i<10000;i++){
			sb+="In Test";
		}
		return sb;
	}
	static StringBuffer useStringBuffer(){
		StringBuffer sb = new StringBuffer("Test");
		for(int i=0;i<10000;i++){
			sb.append("In Testing");
		}
		return sb;
	}
	static StringBuilder useStringBuilder(){
		 StringBuilder sb = new StringBuilder("Test");  
	        for (int i=0; i<10000; i++){  
	            sb.append("In Testing");  
	        } 
	        return sb;
	}
	public static void main(String[] args){
		//.out.print("from command line "+args[0]);
		String s1 = "Bodh";
		String s2 = s1.concat("Gaya");
		System.out.println(s2);
		String s3 = "Harsh";
		String s4 = "Harsha";
		System.out.println("compare "+s3.compareTo(s4));
		StringBuffer sb = new StringBuffer("Harvey");
		sb.append("Specter");
		System.out.println(" "+sb);
		long time1 = System.currentTimeMillis();
		useStringMethod();
		System.out.println("time for string "+
		(System.currentTimeMillis() - time1)+" ms");
		long time2 = System.currentTimeMillis();
		useStringBuffer();
		System.out.println("time for string buffer "+
		(System.currentTimeMillis() - time2)+" ms");
		long time3 = System.currentTimeMillis();
		useStringBuilder();
		System.out.println("time for string builder "+
				(System.currentTimeMillis() - time3)+" ms");
	}
}
