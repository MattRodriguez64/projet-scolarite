package exam;

import java.util.ArrayList;
import java.util.Date;

import person.Student;

public class Project extends Exam {
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Project() {}
	
	public Project(Date examinationDate, String duration, int coefficient, ArrayList<Student> studentList) {
		super(examinationDate, duration, coefficient);
		setStudentList(studentList);
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

}
