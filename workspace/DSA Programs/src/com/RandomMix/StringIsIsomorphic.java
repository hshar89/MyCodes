package PractiseJavaPrograms;

import java.util.HashMap;

public class StringIsIsomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s1 = "aabccdaa";
       String s2 = "xxyzrwxx";
       if(areIsomorphic(s1,s2)){
       System.out.println("yes");
       }else{
       System.out.println("no");
       }
       String ran = "1abc23";

       int a = 'a';
       System.out.println("ran "+a);
       
	}
	 public static boolean areIsomorphic(String s1,String s2)
	    {
	        // Your code here
	        int n = s1.length();
	        int m = s2.length();
	        if(n!=m){
	            return false;
	        }
	        HashMap<Character,Character> mp = new HashMap<Character,Character>();
	        for(int i=0;i<n;i++){
	            if(mp.containsKey(s1.charAt(i))){
	                if(mp.get(s1.charAt(i)) != s2.charAt(i)){
	                    return false;
	                }
	            }else{
	                mp.put(s1.charAt(i),s2.charAt(i));
	            }
	        }
	        return true;
	    }
	 public static boolean areIsomorphic2(String s1,String s2)
	    {
	        // Your code here
	        int n = s1.length();
	        int m = s2.length();
	        if(n!=m){
	            return false;
	        }
	        int[] arr1 = new int[256];
	        int[] arr2 = new int[256];
	        for(int i=0;i<n;i++){
	            int a = s1.charAt(i);
	            int b = s2.charAt(i);
	            if(arr1[a] != 0 && arr2[b]!=0){
	                if(b != arr1[a] || a!=arr2[b]){
	                    return false;
	                }
	            }else if(arr1[a] != 0 || arr2[b] != 0){
	                return false;
	            }else{
	                arr1[a] = b;
	                arr2[b] = a;
	            }
	        }
	        
	        return true;
	    }
}
