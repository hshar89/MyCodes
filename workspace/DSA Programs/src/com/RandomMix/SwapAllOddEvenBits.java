package PractiseJavaPrograms;

public class SwapAllOddEvenBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int num = 23;
      int evenBitOne = 0xAAAAAAAA;
	    int oddBitOne = 0x55555555;
	    int evenBitRightShift = (num&evenBitOne)>>1;
	    int oddBitLeftShift = (num&oddBitOne)<<1;
	    System.out.println("result "+(evenBitRightShift^oddBitLeftShift));
	}
	

}
