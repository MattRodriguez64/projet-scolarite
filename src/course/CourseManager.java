package course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csv.CsvFileManager;
import person.TeacherManager;

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
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filepath));
			String line;
			String[] lineSplitted;
			
			try {
				while((line = buffer.readLine()) != null) {
					lineSplitted = line.split(",");
					
					Course course = new Course(Integer.parseInt(lineSplitted[0]), 
							lineSplitted[1], 
							((TeacherManager) params[0]).getTeacher(lineSplitted[2]));
					getCourseList().add(course);
					System.out.println(course.toString());
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
	
	public void addCourse(Course course) {
		boolean isUnique = true;
		for(Course currentCourse : getCourseList()) {
			if(currentCourse.isEqual(course)) {
				isUnique = false;
				break;
			}
		}
		if(isUnique) {
			getCourseList().add(course);
			writeCsvFile();
		}
	}
	
	public void modifyCourse(Course oldCourse, Course newCourse) {
		if(oldCourse.isEqual(newCourse)) {
			deleteCourse(oldCourse);
			addCourse(newCourse);
		}
	}
	
	public void deleteCourse(Course course) {
		getCourseList().remove(course);
		writeCsvFile();
	}
	
	public void allCourses() {
		if(!getCourseList().isEmpty()) {
			System.out.println(getCourseList().size());
			for(Course course : getCourseList()) {
				System.out.println("---------------------------------");
				System.out.println("CourseID : "+course.getId()+"\nCourseName : "+course.getName()+"\nTeacher : "+course.getTeacher().getAcademicEmail());
				System.out.println("---------------------------------");
			}
		}
	}

}
