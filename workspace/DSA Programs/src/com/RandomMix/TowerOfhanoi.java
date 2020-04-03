package PractiseJavaPrograms;

public class TowerOfhanoi {
   public static long moves;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TowerOfhanoi t = new TowerOfhanoi();
        t.toh(1, 1, 3, 2,t.moves);
        System.out.println(t.moves);
        System.out.println("raised to power "+power(71535,53517));
	}
	public static int power(int N, int R){
			int p;
			long q;
			int x = 1000000007;
			if(R == 0)
			{
			return 1;
			}

			if( R % 2 == 0)
			{
			q = ( (long) (power(N,R/2) % x) * (power(N,R/2) % x)) % x;
			if(q < 0)
			q = (q + x) % x;
			p = (int) q;
			return p;
			}
			else
			{
			q = (((long) (N % x) * (power(N,R-1) % x)) % x);
			if(q < 0)
			q = (q + x) % x;
			p = (int) q;
			return p;
			}
		}
	public void toh(int N, int from, int to, int aux,long moves) {
        // Your code here
		TowerOfhanoi.moves++;
        if(N==1){
            System.out.println("move disc "+N+" from rod "+from+" to "+to);
            return;
        }
        toh(N-1,from,aux,to,moves);
        System.out.println("move disc "+N+" from rod "+from+" to "+to);
        toh(N-1,aux,to,from,moves);
    }

}
