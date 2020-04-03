package multithreading;

public class Runtime1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        //Runtime.getRuntime().exec("notepad");
        Runtime r1 = Runtime.getRuntime();
        System.out.println("free memory: "+r1.freeMemory());
        System.out.println("Total memory: "+r1.totalMemory());
        for(int i=0;i<10000;i++){
        	new Runtime1();
        }
        System.out.println("free memory after runtime: "+r1.freeMemory());
        System.gc();
        System.out.println("free memory after gc: "+r1.freeMemory());
        //System.out.println("free memory: "+Runtime.getRuntime().freeMemory());
        //System.out.println("free memory: "+Runtime.getRuntime().availableProcessors());
	}

}
