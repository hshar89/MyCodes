package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.Collections;

public class powerSetUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String a = "ard";
      ArrayList<String> ans = powerSet(a);
      Collections.sort(ans);
      for(String s: ans){
    	  System.out.print(s +" ");
      }
	}
	static ArrayList<String> powerSet(String s)
    {
        // add your code here
		ArrayList<String> al = new ArrayList<String>();
        if(s.length() == 1){       	
        	al.add(s);
            return al;
        }
        for(int i=0;i<s.length();i++){
        	//al.addAll(powerSet(s));
            al.addAll(powerSet(s.substring(i,s.length()-1)));
        }
        return al;
    }

}
