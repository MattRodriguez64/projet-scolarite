package grade;

import person.Student;
import course.Course;

public class Grade {
	
	private double grade;
	private Student student;
	private Course course;
	
	public Grade() {}
	
	public Grade(double grade, Student student, Course course) {
		setGrade(grade);
		setStudent(student);
		setCourse(course);
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
