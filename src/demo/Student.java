package demo;

public class Student {
	private int id;
	private String subject;
	private int marks;
	
	
	
	public Student(int id, String subject, int marks) {
		this.id = id;
		this.subject = subject;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", subject=" + subject + ", marks=" + marks + "]";
	}
}
