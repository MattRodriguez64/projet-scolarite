package person;

import java.util.ArrayList;

import csv.CsvFileManager;

public class StudentManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\person\\students.csv";
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public StudentManager() {}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void addStudent(Student student) {
		getStudentList().add(student);
	}
	
	
	public Student getStudent(int studentId) {
		Student currentStudent = new Student();
		if(!getStudentList().isEmpty()) {
			for(Student student : getStudentList()) {
				if(student.getStudentId() == studentId) {
					currentStudent = student;
					System.out.println("FIND");
					break;
				}
			}
		}
		return currentStudent;
	}

	@Override
	public void writeCsvFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCsvFile(Object[] params) {
		// TODO Auto-generated method stub
		
	}

}
