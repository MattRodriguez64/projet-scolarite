package person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getStudentList().isEmpty()) {
				for(Student student : getStudentList()) 
					buffer.append(student.getLastName()+","+
				student.getFirstName()+","+
							student.getAcademicEmail()+","+
				student.getStudentId()+","+
							student.getSocialSecurityNumber()+","+
				student.getBirthplace()+","+
							student.getBirthday()+","+
				student.getUniversityClass()+","+
							student.getPersonalEmail()+"\n");
				buffer.flush();
				buffer.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void readCsvFile(Object[] params) {
		// TODO Auto-generated method stub
		
	}
	
    public Student getStudent(int studentId) {
        Student currentStudent = new Student();
        if(!getStudentList().isEmpty()) {
            for(Student student : getStudentList()) {
                if(student.getStudentId() == studentId) {
                    currentStudent = student;
                    break;
                }
            }
        }
        return currentStudent;
    }
	
	public void addStudent(Student student) {
		boolean isUnique = true;
		for(Student currentStudent : getStudentList()) {
			if(currentStudent.isEqual(student)) {
				isUnique = false;
				break;
			}
		}
		if(isUnique) {
			getStudentList().add(student);
			writeCsvFile();
		}
	}
	
	public void deleteStudent(Student student) {
		getStudentList().remove(student);
		writeCsvFile();
	}

}
