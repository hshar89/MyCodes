package PractiseJavaPrograms;

public class ReverseEachWord {
    static String reverseWord(String wd){
    	StringBuffer sb = new StringBuffer(wd);
    	sb.reverse();
    	return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String test = "this is javapoint";
    String[] strA = test.split("\\s");
    String rev ="";
    for(String s: strA){
    	rev+= " "+reverseWord(s);
    }
    System.out.println(rev.trim());
	}

}
