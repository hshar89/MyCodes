package com.RandomMix;
public class PallindroneNumber {
static boolean checkPallindrone(int numToCheck){
	int revNum = getReverseOfNumber(numToCheck);
	System.out.print("rev num "+revNum);
	if(revNum == numToCheck){
		return true;
	}else{
		return false;
	}
}
static int getReverseOfNumber(int num){
	int a = num,b=0,c=0;
	while(a>0){
	 b=a%10;
	 a = a/10;
	 c =(c*10)+b;
	}
	return c;
}
public static void main(String args[]){
    int num = 12321;
    if(checkPallindrone(num)){
    	System.out.print("it is palindrome");
    }else{
    	System.out.print("Not a palindrome");
    }
}
}
