package LearningFromGFG;
class Test<T>{
	T obj;
	public Test(T obj){
		this.obj = obj;
	}
	public void doSomething(){
		System.out.println("This is from generic class");
	}
	public T getObj(){
		return this.obj;
	}
}
public class GenericClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test<Integer> ti = new Test<Integer>(45);
        System.out.println(ti.getObj());
        ti.doSomething();
        Test<String> ts = new Test<String>("this is corrupt");
        ts.doSomething();
        System.out.println(ts.getObj());
	}

}
