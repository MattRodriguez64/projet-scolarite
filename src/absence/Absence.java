package absence;

import java.util.Date;

import course.Course;
import person.Student;


public class Absence {

	private Date absenceDate;
	private String reason;
	private Student student;
	private Course course;
	
	public Absence() {}
	
	public Absence(Date absenceDate, String reason, Student student, Course course) {
		setAbsenceDate(absenceDate);
		setReason(reason);
		setStudent(student);
		setCourse(course);
	}

	public Date getAbsenceDate() {
		return absenceDate;
	}

	public void setAbsenceDate(Date absenceDate) {
		this.absenceDate = absenceDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
