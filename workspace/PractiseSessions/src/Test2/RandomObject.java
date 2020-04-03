package Test2;

public class RandomObject implements Cloneable{
	
	private int id;
	private String name;
	public RandomObject(int id, String name) {
		this.id= id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
