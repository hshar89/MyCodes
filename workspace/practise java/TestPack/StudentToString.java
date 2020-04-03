package TestPack;

public class StudentToString {
    int rollNo;
    String Name;
    String studyClass;
    StudentToString(int rollNo, String Name, String studyClass){
    	this.rollNo = rollNo;
    	this.Name = Name;
    	this.studyClass = studyClass;
    }
    public String toString(){
    	return Name+" "+rollNo+" "+studyClass;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      StudentToString sb = new StudentToString(34,"bacha","Sixth");
      System.out.println(sb);
	}

}
