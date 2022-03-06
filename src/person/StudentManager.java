package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	

	@SuppressWarnings("deprecation")
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
							student.getBirthday().getDate()+"-"+student.getBirthday().getMonth()+"-"+student.getBirthday().getYear()+","+
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
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filepath));
			String line;
			String[] lineSplitted;
			
			try {
				while((line = buffer.readLine()) != null) {
					lineSplitted = line.split(",");
					String[] dateSplitted = lineSplitted[6].split("-");
					
					@SuppressWarnings("deprecation")
					Student currentStudent = new Student(lineSplitted[0],
							lineSplitted[1],
							lineSplitted[2],
							Integer.parseInt(lineSplitted[3]),
							lineSplitted[4],
							lineSplitted[5],
							new Date(Integer.parseInt(dateSplitted[2]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(dateSplitted[0]), 0, 0),
							lineSplitted[7], 
							lineSplitted[8]);
					
					getStudentList().add(currentStudent);
					System.out.println(currentStudent.toString());
				}
				buffer.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
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
