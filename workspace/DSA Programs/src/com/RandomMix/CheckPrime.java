package PractiseJavaPrograms;

public class CheckPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a = 50;
       System.out.print("new string "+new String(new char[a]));
       System.out.println("is prime "+isPrime(a));
	}
	static boolean isPrime(int n){
	     return ! new String(new char[n]).matches(".?|(..+?)\\1+"); // crazy
	 }
}
