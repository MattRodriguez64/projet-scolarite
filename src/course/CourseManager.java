package course;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csv.CsvFileManager;

public class CourseManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\course\\courses.csv";
	
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	public CourseManager() {}
	
	public CourseManager(ArrayList<Course> courseList) {
		setCourseList(courseList);
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getCourseList().isEmpty()) {
				for(Course course : getCourseList())
					buffer.append(course.getId()+","+course.getName()+","+course.getTeacher().getAcademicEmail()+"\n");
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
	
	public void addCourse(Course course) {
		getCourseList().add(course);
	}
	
	public Course getCourse(int courseId) {
		Course currentCourse = new Course();
		if(!getCourseList().isEmpty()) {
			for(Course course : getCourseList()) {
				if(course.getId() == courseId) {
					currentCourse = course;
					break;
				}
			}
		}
		return currentCourse;
	}

}
