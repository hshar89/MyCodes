package TestPack;

import java.util.ArrayList;

public class TestCloning implements Cloneable{
int rollno;
String name;
TestCloning(String name,int rollno){
	this.name = name;
	this.rollno = rollno;
}
public Object clone() throws CloneNotSupportedException{
	return super.clone();
}
public static void main(String args[]){  
	try{
		TestCloning t1 = new TestCloning("test",67);
		TestCloning t2 = (TestCloning)t1.clone();
		System.out.print(t1.rollno+" "+t1.name);  
		System.out.print(t2.rollno+" "+t2.name);  
		/*String ab = "";
		ab.isEmpty();
		int[] ar1= {1,2,3,5,6,7};
		int[] ar2 ={1,4,8,235,657,75};
		for(int i=0;i<ar1.length;i++){
			System.out.print("ar1 element "+ar1[i]+" ");
			for(int j=0;j<ar2.length;j++){
				if(ar2[j]>10){
					break;
				}
				else{
					System.out.print("ar2 element "+ar2[j]+" ");
				}
			}
			System.out.println();
		}*/
	}catch(CloneNotSupportedException c){
		System.out.print("exceptionmsg "+c.getMessage());
	}
}
}
