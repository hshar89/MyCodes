package Test4;

public class Student {
	
	private String fname;
	private String lname;
	private int rollno;
	private String exam;
	private int marks;
	
	
	public Student(String fname, String lname, int rollno, String exam, int marks) {
		this.fname = fname;
		this.lname = lname;
		this.rollno = rollno;
		this.exam = exam;
		this.marks = marks;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
