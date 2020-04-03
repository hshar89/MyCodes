package PractiseJavaPrograms;

public class QuadraticRoots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*quadraticRoots(752,904,164);
		int num = 10;
		double f=1.0d;
		while(num>0){
			f+=Math.log10(num);
			num--;
		}
		System.out.println(" num of digits "+(int)f);*/
		System.out.println("exactly 3 divisors "+exactly3Divisors(50));
	}
	 public static int exactly3Divisors(int N)
	    {
	        //Your code here
	        if(N<4){
	            return 0;
	        }
	        int count =0;
	        outer:
	        for(int i=4;i<=N;i++){
	            int div = 2;
	            System.out.println(" i "+i);
	            inner:
	            for(int j =2;j<=(i/2);j++){
	                if(i%j == 0){
	                    div++;
	                }
	                if(div >3){
	                	continue outer;
	                }
	            }
	            if(div == 3){
	                count++;
	            }
	        }
	        return count;
	    }
	 public static void quadraticRoots(int a,int b,int c)
	    {
	        //Your code here
	        if(a==0){
	            System.out.print("Invalid");
	            return;
	        }
	        int a1 = b*b;
	        System.out.println("a1 "+a1);
	        int d1 = a1 - (4*a*c);
	        System.out.println("d1 "+d1);
	        if(d1>=0){
	        double d = Math.pow(d1,0.5);
	        System.out.println(" d "+d);
	        double d2 = (Double.valueOf(b)/(2.0d*Double.valueOf(a)))*(-1.0d);
	        int root1 = (int)Math.floor((d)+(d2));
	        int root2 = (int)Math.floor(((-(d) - (b))/(2*a)));
	        System.out.print(root1+" "+root2);
	        }else{
	            System.out.print("Imaginary");
	        }
	    }
}
