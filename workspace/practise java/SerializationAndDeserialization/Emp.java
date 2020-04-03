package SerializationAndDeserialization;
import java.io.*;
public class Emp implements Serializable{
	private static final long serialVersionUID = 
            129348938L; 
	String name;
	static int a;
	transient int b;
	int id;
	public Emp(String name,int a,int b,int id){
		this.name = name;
		this.a= a;
		this.b = b;
		this.id = id;
	}
}
