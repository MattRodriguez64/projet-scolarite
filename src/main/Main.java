package main;

import java.util.Date;
import java.util.Scanner;

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
		
		/*
		boolean isRunning = true;
		boolean isRunningManager = true;
		
		StudentManager studentManager = new StudentManager();
		CourseManager courseManager = new CourseManager();
		ExamManager examManager = new ExamManager();
		TeacherManager teacherManager = new TeacherManager();
		AbsenceManager absenceManager = new AbsenceManager();
		RegistrationManager registrationManager = new RegistrationManager();
		GradeManager gradeManager = new GradeManager();
		
		teacherManager.readCsvFile(null);
		Object[] courseManagerParams = {teacherManager};
		studentManager.readCsvFile(null);
		courseManager.readCsvFile(courseManagerParams);
		Object[] absenceManagerParams = {studentManager, courseManager};
		examManager.readCsvFile(null);
		absenceManager.readCsvFile(absenceManagerParams);
		Object[] registrationManagerParams = {courseManager, studentManager};
		registrationManager.readCsvFile(registrationManagerParams);
		
		
		
		
		
		while(isRunning) {
			System.out.println("[1] Student Manager");
			System.out.println("[2] Course Manager");
			System.out.println("[3] Exam Manager");
			System.out.println("[4] Absence Manager");
			System.out.println("[5] Registration Manager");
			System.out.println("[6] Grade Manager");		
			System.out.println("[0] Quitter");
				
			Scanner scan = new Scanner(System.in);
			int choix = scan.nextInt();
	
				if (choix == 1) {
					while(isRunningManager) {
						System.out.println("[1] Add Student");
						System.out.println("[2] Modify Student");
						System.out.println("[3] Delete Student");
						System.out.println("[4] Order Student by Name");
						System.out.println("[5] Order Student by University Class");
						System.out.println("[6] Add Teacher");
						System.out.println("[7] Delete Teacher");
						System.out.println("[0] Go to the main menu");

						choix = scan.nextInt();
						scan.close();
	
						switch (choix) {
	
						case 1:
							int sizeBefore = studentManager.getStudentList().size();
							System.out.println("-- Add Student --");
							Scanner scanStudent = new Scanner(System.in);
							System.out.println("LastName : ");
							String lastName = scanStudent.next();
							System.out.println("FirstName : ");
							String firstName = scanStudent.next();
							System.out.println("AcademicEmail : ");
							String academicEmail = scanStudent.next();
							System.out.println("StudentID : ");
							String studentId = scanStudent.next();
							System.out.println("SocialSecurityNumber : ");
							String socialSecurityNumber = scanStudent.next();
							System.out.println("Birthplace : ");
							String birthplace = scanStudent.next();
							System.out.println("Birthday : \nDay ?");
							String day = scanStudent.next();
							System.out.println("Month ?");
							String month = scanStudent.next();
							System.out.println("Year ?");
							String year = scanStudent.next();
							System.out.println("University class ?");
							String universityClass = scanStudent.next();
							System.out.println("Personal Email ?");
							String personalEmail = scanStudent.next();
							Student student = new Student(lastName, 
									firstName, 
									academicEmail, 
									Integer.parseInt(studentId), 
									socialSecurityNumber, 
									birthplace, 
									new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), 0, 0), 
									universityClass, 
									personalEmail);
							studentManager.addStudent(student);
							
							if((sizeBefore+1) == studentManager.getStudentList().size())
								System.out.println("Registration successfully completed");
							else
								System.out.println("An error occured");	
							break;
	
						case 2:
							//studentManager.modifyStudent(null, null);
							break;
	
						case 3:
							studentManager.deleteStudent(null);
							break;
	
						case 4:
							studentManager.studentOrderByName();
							break;
	
						case 5:
							studentManager.studentOrderByClass();
							break;
	
						case 6:
							teacherManager.addTeacher(null);
							break;
	
						case 7:
							teacherManager.deleteTeacher(null);
							break;
						case 0:
							isRunningManager = false;
							break;
	
						default: System.out.println("Please choose a valid number !");
						
	
						}
					}
					isRunningManager = true;
	
				} else if (choix == 2) {
					while(isRunningManager) {
						System.out.println("[1] Add Course");
						System.out.println("[2] Modify Course");
						System.out.println("[3] Delete Course");
						System.out.println("[4] Show Courses");
						System.out.println("[0] Go to the main menu");
						
						choix = scan.nextInt();
						scan.close();
	
						switch (choix) {
	
						case 1:
							courseManager.addCourse(null);
							break;
	
						case 2:
							courseManager.modifyCourse(null, null);
							break;
						case 3:
							courseManager.deleteCourse(null);
							break;
	
						case 4:
							courseManager.allCourses();
							break;
						case 0:
							isRunningManager = false;
							break;
							
						default: 
							System.out.println("Please choose a valid number !");
	
						}
					}
					isRunningManager = true;
	
				} else if (choix == 3) {
					while(isRunningManager) {
						System.out.println("[1] Add Exam");
						System.out.println("[2] Delete Exam");
						System.out.println("[0] Go to the main menu");
						
						choix = scan.nextInt();
						scan.close();
	
						switch (choix) {
	
						case 1:
							examManager.addExam(null);
							break;
	
						case 2:
							examManager.deleteExam(null);
							break;
						case 0:
							isRunningManager = false;
							break;
							
						default:
							System.out.println("Please choose a valid number !");
						}
					}
					isRunningManager = true;
	
				} else if (choix == 4) {
					while(isRunningManager) {
						System.out.println("[1] Add Absence");
						System.out.println("[2] Modify Absence");
						System.out.println("[3] Delete Absence");
						System.out.println("[4] All absences from a Course");
						System.out.println("[5] All absences from a Student");
						System.out.println("[0] Go to the main menu");
						
						choix = scan.nextInt();
						scan.close();
						
						switch (choix) {
						
						}
					}
					
				} else if (choix == 5) {
					while(isRunningManager) {
						System.out.println("[1] Add Registration");
						System.out.println("[2] Delete Registration");
						System.out.println("[3] Student Erolled in the Course");
						System.out.println("[4] Courses in which the student is registered");
						System.out.println("[0] Go to the main menu");
						
						choix = scan.nextInt();
						scan.close();
						
						switch (choix) {
						
						}
					}
					
				} else if (choix == 6) {
					while(isRunningManager) {
						System.out.println("[1] Add Grade");
						System.out.println("[2] Modify Grade");
						System.out.println("[3] Delete Grade");
						System.out.println("[4] All Grades belonging to a Student");
						System.out.println("[0] Go to the main menu");
						
						choix = scan.nextInt();
						scan.close();
	
						switch (choix) {
	
						case 1:
							gradeManager.addGrade(null);
							break;
	
						case 2:
							gradeManager.modifyGrade(null, null);
							break;
	
						case 3:
							gradeManager.deleteGrade(null);
							break;
	
						case 4:
							break;
							
						case 0: 
							isRunningManager = false;
							break;
						default:
							System.out.println("Please choose a valid number !");
	
						}
					}
					isRunningManager = true;
	
				} 
				scan.close();

			}
			
		
	}*/
		
		
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
