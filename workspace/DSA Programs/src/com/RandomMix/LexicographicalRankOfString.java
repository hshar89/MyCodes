package com.RandomMix;

public class LexicographicalRankOfString {
	static final int m=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "String";
       System.out.println("rank "+findRank(s));
	}
	static int findRank(String s) 
    {
        int n=s.length();
    
        long rank=0;
        for(int i=0;i<n-1;i++){
            int a = s.charAt(i);
           int j,count =0;
           for(j=i+1;j<n;j++){
               if(s.charAt(j) == a){
                   return 0;
               }
               if(s.charAt(j)<a){
                   count++;
               }
           }
           rank= (rank + (count)*fact(n-1-i))%m;
        }
        return (int)rank+1;
    }
    static long fact(int n){
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }

}
