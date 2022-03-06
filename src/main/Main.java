package main;

import java.util.Date;

import course.Course;
import course.CourseManager;
import exam.Exam;
import exam.ExamManager;
import grade.Grade;
import grade.GradeManager;
import person.Student;
import person.StudentManager;
import person.Teacher;
import person.TeacherManager;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		GradeManager gradeManager = new GradeManager();

		Date birthday = new Date(2001, 5, 4, 0, 0);

		
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", birthday, "Info", "test@perso.com");
		Exam exam01 = new Exam("prog-01", null, "2h", 4);
		Teacher teacher01 = new Teacher("Teacher01", "Teacher01", "teacher01@univ.com");
		Course course01 = new Course(1, "Prog", teacher01);
		Course course02 = new Course(2, "BDDs", teacher01);
		
		Grade grade01 = new Grade(17.8d, student01, course01, exam01);
		gradeManager.addGrade(grade01);
		
		Grade grade02 = new Grade(16d, student01, course01, exam01);
		
		TeacherManager teacherManager = new TeacherManager();
		teacherManager.addTeacher(teacher01);
		
		CourseManager courseManager = new CourseManager();
		Object[] courseParams = {teacherManager};
		courseManager.readCsvFile(courseParams);
		courseManager.addCourse(course01);
		courseManager.addCourse(course02);
		
		StudentManager studentManager = new StudentManager();
		studentManager.addStudent(student01);
		
		ExamManager examManager = new ExamManager();
		examManager.addExam(exam01);
		
		
		gradeManager.writeCsvFile();
		Object[] gradeParams = {studentManager, courseManager, examManager};

		gradeManager.modifyGrade(grade01, grade02);
		gradeManager.readCsvFile(gradeParams);
		
		
		courseManager.allCourses();
		studentManager.readCsvFile(null);
		

	}

}
