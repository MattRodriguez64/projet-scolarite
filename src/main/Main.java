package main;

import java.util.Date;

import absence.Absence;
import absence.AbsenceManager;
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
import registration.Registration;
import registration.RegistrationManager;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		GradeManager gradeManager = new GradeManager();

		Date birthday = new Date(2001, 5, 4, 0, 0);
		Date examDate01 = new Date(2022, 3, 7, 0, 0);

		
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", birthday, "Info", "test@perso.com");
		Student student02 = new Student("a", "test", "testa@univ.com", 2, "1001105556456", "Test", birthday, "Info", "testa@perso.com");
		Student student03 = new Student("b", "test", "testb@univ.com", 3, "1001452156456", "Test", birthday, "Info", "testb@perso.com");
		
		Exam exam01 = new Exam("prog-01", examDate01, "2h", 4);
		Teacher teacher01 = new Teacher("Teacher01", "Teacher01", "teacher01@univ.com");
		Course course01 = new Course(1, "Prog", teacher01);
		Course course02 = new Course(2, "BDDs", teacher01);
		
		Grade grade01 = new Grade(17.8d, student01, course01, exam01);
		gradeManager.addGrade(grade01);
		
		Grade grade02 = new Grade(16d, student01, course01, exam01);
		gradeManager.addGrade(grade02);
		
		TeacherManager teacherManager = new TeacherManager();
		teacherManager.addTeacher(teacher01);
		
		CourseManager courseManager = new CourseManager();
		Object[] courseParams = {teacherManager};
		courseManager.readCsvFile(courseParams);
		courseManager.addCourse(course01);
		courseManager.addCourse(course02);
		
		StudentManager studentManager = new StudentManager();
		studentManager.addStudent(student01);
		studentManager.addStudent(student02);
		studentManager.addStudent(student03);
		
		studentManager.studentOrderByName();
		
		ExamManager examManager = new ExamManager();
		//examManager.addExam(exam01);
		examManager.readCsvFile(null);
		
		
		gradeManager.writeCsvFile();
		//Object[] gradeParams = {studentManager, courseManager, examManager};

		//gradeManager.modifyGrade(grade01, grade02);
		//gradeManager.readCsvFile(gradeParams);
		
		
		courseManager.allCourses();
		studentManager.readCsvFile(null);
		
		gradeManager.allExamsGrade(exam01);
		
		RegistrationManager registrationManager = new RegistrationManager();
		registrationManager.addRegistration(new Registration(course01, student01));
		registrationManager.addRegistration(new Registration(course02, student01));
		
		Object[] studentsGradeParams = {registrationManager};
		gradeManager.allStudentsGrade(student01, studentsGradeParams);
		
		System.out.println("StudentCourses test : ");
		registrationManager.studentCourses(student01);
		System.out.println("studentsEnrolled test : ");
		registrationManager.studentsEnrolled(course01);
		
		AbsenceManager absenceManager = new AbsenceManager();
		Absence absence01 = new Absence(examDate01, "Sick", student02, course02);
		Object[] absenceParams = {studentManager, courseManager};
		absenceManager.addAbsence(absence01);
		absenceManager.readCsvFile(absenceParams);
		

	}

}
