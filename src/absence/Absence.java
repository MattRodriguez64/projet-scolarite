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
	
	@SuppressWarnings("deprecation")
	public String toString() {
		String message;
		message = "Absence : \nStudentID : "+getStudent().getStudentId()+"\nCourse : "+getCourse().getName()+"\nReason : "+getReason()+"\nAbsenceDate : "+getAbsenceDate().getDate()+"/"+getAbsenceDate().getMonth()+"/"+getAbsenceDate().getYear();
		return message;
	}
	
	public boolean isEqual(Absence a) {
		if((a.getStudent().getStudentId() == getStudent().getStudentId()) &&
				(a.getReason().equals(getReason())) &&
				(a.getCourse().getId() == getCourse().getId()) &&
				(a.getAbsenceDate().equals(getAbsenceDate())))
			return true;
		return false;
	}
}
