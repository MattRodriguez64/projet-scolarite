package main;

import course.Course;
import course.CourseManager;
import exam.Exam;
import exam.ExamManager;
import grade.Grade;
import grade.GradeManager;
import person.Person;
import person.Student;
import person.StudentManager;
import person.Teacher;

public class Main {

	public static void main(String[] args) {
		
		GradeManager gradeManager = new GradeManager();
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", null, "Info", "test@perso.com");
		Exam exam01 = new Exam("prog-01", null, "2h", 4);
		Teacher teacher01 = new Teacher("Teacher01", "Teacher01", "teacher01@univ.com");
		Course course01 = new Course(1, "Prog", teacher01);
		
		Grade grade01 = new Grade(17.8d, student01, course01, exam01);
		gradeManager.addGrade(grade01);
		
		Grade grade02 = new Grade(16d, student01, course01, exam01);
		
		CourseManager courseManager = new CourseManager();
		courseManager.addCourse(course01);
		
		StudentManager studentManager = new StudentManager();
		studentManager.addStudent(student01);
		
		ExamManager examManager = new ExamManager();
		System.out.println(studentManager.getStudent(student01.getStudentId()).getAcademicEmail());
		examManager.addExam(exam01);
		
		gradeManager.writeCsvFile();
		Object[] gradeParams = {studentManager, courseManager, examManager};

		gradeManager.modifyGrade(grade01, grade02);
		gradeManager.readCsvFile(gradeParams);
		

	}

}
