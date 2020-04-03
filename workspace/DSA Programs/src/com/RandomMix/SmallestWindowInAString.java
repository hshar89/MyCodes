package PractiseJavaPrograms;

import java.util.HashSet;

public class SmallestWindowInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s = "zoomlazapzo";
      String t = "oza";
      s="timetopractice";
      
      t="toc";
      System.out.println(smallestWindow2(s,t));
	}
	public static String smallestWindow2(String s, String t){
		// Your code here
		int n = s.length();
		int m = t.length();
		int[] count_pat = new int[26];
		int[] count_str = new int[26];
		for(int i=0;i<m;i++){
		    count_pat[t.charAt(i) - 'a']++;
		}
		int len = 0,count=0,min=Integer.MAX_VALUE,start=0,start_index = -1;
		for(int i=0;i<n;i++){
		    int a = s.charAt(i) - 'a';
		    
		 // count occurrence of characters of string 
		    count_str[a]++;
		    
		 // If string's char matches with pattern's char 
		// then increment count 
		    if(count_pat[a]!=0 && count_str[a]<=count_pat[a]){
		        count++;
		    }
		    
		 // if all the characters are matched 
		if(count == m){
			
			// Try to minimize the window i.e., check if 
		    // any character is occurring more no. of times 
		    // than its occurrence in pattern, if yes 
		    // then remove it from starting and also remove 
		    // the useless characters. 
		    while((count_str[s.charAt(start)-'a']>count_pat[s.charAt(start)-'a'])|| 
		    (count_pat[s.charAt(start)-'a']==0)){
		    	System.out.println("start "+start);
		        if(count_str[s.charAt(start)-'a'] > count_pat[s.charAt(start)-'a']){
		            count_str[s.charAt(start)-'a']--;
		        }
		        start++;
		    }
		 // update window size     
		        len = i-start+1;
		        if(len<min){
		        min = len;
		        start_index = start;
		        }
		    }
		}     
		    // If no window found
		   if(start_index == -1){
		       return "-1";
		   }else{
		    return s.substring(start_index,start_index+min);
		   }
    }
	public static String smallestWindow(String s, String t){
        // Your code here
        int n = s.length();
        int m = t.length();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            char a = s.charAt(i);
            if(t.indexOf(a) != -1){
                arr[i] = a;
            }else{
                arr[i] = 0;
            }
        }
        int len = 0,min=Integer.MAX_VALUE,start=-1,end=-1;
        for(int i=0;i<n-m;i++){
            int j=i;
            HashSet<Integer> hs = new HashSet<Integer>();
          while(j<n){
              if(arr[j] != 0){
                  hs.add(arr[j]);
              }
              if(hs.size() == m){
                  break;
              }
              j++;
          }
          if(j==n){
              break;
          }
          //System.out.println("j "+j+" i "+i);
          len = j-i+1;
          if(len<min){
              min = len;
              start = i;
              end = j;
          }
        }
            if(start == -1){
            	return "-1";
            }
            return s.substring(start,end+1);
    }

}
