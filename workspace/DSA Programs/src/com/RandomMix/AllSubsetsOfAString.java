package PractiseJavaPrograms;

import java.util.HashMap;

public class AllSubsetsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcd";
		//int len = (int)Math.pow(2,a.length());
		//String[] sarr = new String[len];
         AllSubsets(a,0,"");
         System.out.println("\n by  method 2 ");
         AllSubsets2("",a);
         System.out.println("\n printing all permutations ");
         String str = "harsh";
         AllPermutations(str,0,str.length()-1);
         System.out.println("Trying all possible words from phone dic ");
         int [] arr = {2,3,4,7};
         possibleWords(arr,3);
	}
	static void AllSubsets(String a, int index,String sarr){
		int len  = a.length();
		//System.out.println(" index "+index);
		//System.out.println(" sarr "+sarr);
		if(index == a.length()){
			//System.out.println(" printing ");
			System.out.print(sarr+" ");
			return;
		}
		
		AllSubsets(a,index+1,sarr);
		AllSubsets(a,index+1,sarr+a.charAt(index));
	}
	static void AllSubsets2(String p, String a){
		System.out.print(p+" ");
		for(int i=0;i<a.length();i++){
			AllSubsets2(p+a.charAt(i),a.substring(i+1));
		}
	}
	static void AllPermutations(String s, int l, int r){
		if(l==r){
			System.out.print(s+" ");
		}else{
			for(int i=l;i<=r;i++){
				s = swap(s,l,i);
				AllPermutations(s,l+1,r);
			}
		}
	}
	static String swap(String s, int l, int r){
		char[] ch = s.toCharArray();
		char temp = ch[l];
		ch[l] = ch[r];
		ch[r] = temp;
		return String.valueOf(ch);
	}
	static void possibleWords(int a[], int N){
		HashMap<Integer,String> hs = new HashMap<Integer,String>();
		hs.put(2, "ABC");
		hs.put(3, "DEF");
		hs.put(4, "GHI");
		hs.put(5, "JKL");
		hs.put(6, "MNO");
		hs.put(7, "PQRS");
		hs.put(8, "TUV");
		hs.put(9, "WXYZ");
		findAllPossibleWords(hs,a,"",0);
	}
	static void findAllPossibleWords(HashMap<Integer,String> hs, int a[],String str,int l){
		    if(str.length() == a.length){
		    	System.out.print(str+" ");
		    	//return;
		    }else{
		    	//str += hs.get(a[l]).charAt(index);
		    	for(int i =0;i<hs.get(a[l]).length();i++){
		    	findAllPossibleWords(hs,a,str+hs.get(a[l]).charAt(i),l+1);
		    	}
		    	//findAllPossibleWords(hs,a,str+hs.get(a[l]).charAt(index),l+1,index+1);
		    	
		    }
	}

}
