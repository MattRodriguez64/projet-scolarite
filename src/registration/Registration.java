package registration;

import course.Course;
import person.Student;

public class Registration {
	
	private Course course;
	private Student student;
	
	public Registration() {}
	
	public Registration(Course course, Student student) {
		setCourse(course);
		setStudent(student);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
