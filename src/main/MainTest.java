package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import absence.AbsenceManager;
import course.CourseManager;
import exam.ExamManager;
import grade.GradeManager;
import person.Student;
import person.StudentManager;
import person.TeacherManager;
import registration.RegistrationManager;

class MainTest {

	StudentManager studentManager = new StudentManager();
	CourseManager courseManager = new CourseManager();
	ExamManager examManager = new ExamManager();
	TeacherManager teacherManager = new TeacherManager();
	AbsenceManager absenceManager = new AbsenceManager();
	RegistrationManager registrationManager = new RegistrationManager();
	GradeManager gradeManager = new GradeManager();
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAddStudent() {
		Date birthday = new Date(2001, 5, 4, 0, 0);
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", birthday, "Info", "test@perso.com");
		studentManager.addStudent(student01);
		Assertions.assertEquals(1, studentManager.getStudentList().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetStudent() {
		Date birthday = new Date(2001, 5, 4, 0, 0);
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", birthday, "Info", "test@perso.com");
		studentManager.addStudent(student01);
		Student searchedStudent = studentManager.getStudent(1);
		Assertions.assertEquals("test@univ.com", searchedStudent.getAcademicEmail());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test 
	public void testDeleteStudent() {
		Date birthday = new Date(2001, 5, 4, 0, 0);
		Student student01 = new Student("test", "test", "test@univ.com", 1, "1001102156456", "Test", birthday, "Info", "test@perso.com");
		studentManager.deleteStudent(student01);
		Assertions.assertEquals(0, studentManager.getStudentList().size());
	}
	
	@Test
	public void testAddTeacher() {
		
	}
	
	

}
