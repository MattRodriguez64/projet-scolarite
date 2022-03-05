package person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		
	}
	
	public void addTeacher(Teacher teacher) {
		getTeacherList().add(teacher);
	}
	
	public void deleteTeacher(Teacher teacher) {
		getTeacherList().remove(teacher);
	}



}
