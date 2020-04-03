package LearningFromGFG;
class Test2<T,U>{
	T objt;
	U obju;
	Test2(T objt,U obju){
		this.objt = objt;
		this.obju = obju;
	}
	public void print(){
		System.out.println(this.objt);
		System.out.println(this.obju);
	}
}
public class GenericClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 <String, Integer> obj = 
	            new Test2<String, Integer>("GfG", 15); 
	  
	        obj.print(); 
	}

}
