package com.DynamicProgramming;

import java.util.ArrayList;

public class PrintAllCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String abc = "ABCD";
    int n =abc.length();
    calculateColumn(abc,n,"",0);
	}
	public static void calculateColumn(String abc, int n,String st, int index){
	    if(st.length()==n) {
	    	System.out.print(st+" ");
	    	return;
	    }
	    if(index>=n) {
	    	return;
	    }
	    st+=abc.charAt(index);
	    for(int i=index;i<n;i++) {		
	    calculateColumn(abc,n,st,i+1);
	    calculateColumn(abc,n,st,i);
	    }
	        
	}
}
