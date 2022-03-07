package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import csv.CsvFileManager;

public class TeacherManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\person\\teachers.csv";
	
	private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
	public TeacherManager() {}
	
	public TeacherManager(ArrayList<Teacher> teacherList) {
		setTeacherList(teacherList);
	}

	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getTeacherList().isEmpty()) {
				for(Teacher teacher : getTeacherList())
					buffer.append(teacher.getLastName()+","+teacher.getFirstName()+","+teacher.getAcademicEmail()+"\n");
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
					
					Teacher currentTeacher = new Teacher(lineSplitted[0], lineSplitted[1], lineSplitted[2]);
					getTeacherList().add(currentTeacher);
					System.out.println(currentTeacher.toString());
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
	
	
	public Teacher getTeacher(String academicEmail) {
		Teacher currentTeacher = new Teacher();
		if(!getTeacherList().isEmpty()) {
			for(Teacher teacher : getTeacherList()) {
				if(teacher.getAcademicEmail().equals(academicEmail)) {
					currentTeacher = teacher;
					break;
				}
			}
		}
		return currentTeacher;
	}
	
	public void addTeacher(Teacher teacher) {
		boolean isUnique = true;
		for(Teacher currentTeacher : getTeacherList()) {
			if(currentTeacher.isEqual(teacher)) {
				isUnique = false;
				break;
			}
		}
		if(isUnique) {
			getTeacherList().add(teacher);
			writeCsvFile();
		}
	}
	
	public void deleteTeacher(Teacher teacher) {
		getTeacherList().remove(teacher);
	}



}
