package registration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import course.CourseManager;
import csv.CsvFileManager;
import person.Student;
import person.StudentManager;

public class RegistrationManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\registration\\registrations.csv";
	
	private ArrayList<Registration> registrationList = new ArrayList<Registration>();
	
	public RegistrationManager() {}
	
	public RegistrationManager(ArrayList<Registration> registrationList) {
		setRegistrationList(registrationList);
	}
	
	public ArrayList<Registration> getRegistrationList() {
		return registrationList;
	}

	public void setRegistrationList(ArrayList<Registration> registrationList) {
		this.registrationList = registrationList;
	}

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getRegistrationList().isEmpty()) {
				for(Registration registration : getRegistrationList())
					buffer.append(registration.getStudent().getStudentId()+","+registration.getCourse().getId()+"\n");
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
					System.out.println(line);
					
					Registration currentRegistration = new Registration(
							((CourseManager) params[0]).getCourse(Integer.parseInt(lineSplitted[0])), 
							((StudentManager) params[1]).getStudent(Integer.parseInt(lineSplitted[1])));
					System.out.println(currentRegistration.toString());
					getRegistrationList().add(currentRegistration);
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
	
	public Registration getRegistration(int studentId, int courseId) {
		Registration currentRegistration = new Registration();
		if(!getRegistrationList().isEmpty()) {
			for(Registration registration : getRegistrationList()) {
				if((registration.getStudent().getStudentId() == studentId) && (registration.getCourse().getId() == courseId)) {
					currentRegistration = registration;
					break;
				}
			}
		}
		return currentRegistration;
	}
	
	public void addRegistration(Registration registration) {
		boolean isUnique = true;
		for(Registration currentRegistration : getRegistrationList()) {
			if(currentRegistration.isEqual(registration)) {
				isUnique = false;
				break;
			}
		}
		if(isUnique) {
			getRegistrationList().add(registration);
			writeCsvFile();
		}
	}
	
	public void deleteRegistration(Registration registration) {
		getRegistrationList().remove(registration);
		writeCsvFile();
	}
	
	public void studentsEnrolled(Course course) {
		if(!getRegistrationList().isEmpty()) {
			System.out.println("Students Enrolled in Course : " + course.getName() + "\n");
			for(Registration registration : getRegistrationList()) {
				if(registration.getCourse().isEqual(course)) {
					System.out.println(registration.getStudent().toString());
				}
			}
		}
		else {
			System.out.println("The List is empty ! operation cancelled");
		}
	}
	
	public void studentCourses(Student student) {
		if(!getRegistrationList().isEmpty()) {
			System.out.println("Student Enrolled in all the following courses: " + student.getAcademicEmail() + "\n");
			for(Registration registration : getRegistrationList()) {
				if(registration.getStudent().isEqual(student)) {
					System.out.println(registration.getCourse().toString());
				}
			}
		}
		else {
			System.out.println("The List is empty ! operation cancelled");
		}
	}


}
