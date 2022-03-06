package grade;

import person.Student;
import course.Course;
import exam.Exam;

public class Grade {
	
	private double grade;
	private Student student;
	private Course course;
	private Exam exam;
	
	public Grade() {}
	
	public Grade(double grade, Student student, Course course, Exam exam) {
		setGrade(grade);
		setStudent(student);
		setCourse(course);
		setExam(exam);
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public String toString() {
		String message;
		message = "Grade : \n StudentID : " + getStudent().getStudentId() + "\n ExamID : " + getExam().getExamId() + "\n CourseID : " + getCourse().getId() + "\n Grade : " + getGrade();
		return message;
	}
	
	public boolean isEqual(Grade g) {
		if((g.getExam().getExamId() == getExam().getExamId())
				&& (g.getStudent().getStudentId() == getStudent().getStudentId())
				&& (g.getCourse().getId() == getCourse().getId())) {
			return true;
		}
		return false;
	}
	
}
