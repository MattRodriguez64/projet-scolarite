package person;

import java.util.Comparator;
import java.util.Date;

public class Student extends Person{
	
	private int studentId;
	private String socialSecurityNumber;
	private String birthplace;
	private Date birthday;
	private String universityClass;
	private String personalEmail;
	
	public Student() {}
	
	public Student(String lastName, String firstName, String academicEmail, 
			int studentId, String socialSecurityNumber, 
			String birthplace, Date birthday, String universityClass, String personalEmail) {
		super(lastName, firstName, academicEmail);
		setStudentId(studentId);
		setSocialSecurityNumber(socialSecurityNumber);
		setBirthplace(birthplace);
		setBirthday(birthday);
		setUniversityClass(universityClass);
		setPersonalEmail(personalEmail);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUniversityClass() {
		return universityClass;
	}

	public void setUniversityClass(String universityClass) {
		this.universityClass = universityClass;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	
	@SuppressWarnings("deprecation")
	public String toString() {
		String message;
		message = "Student : \nLastName : "+getLastName()+
				"\nFirstName : "+getFirstName()+
				"\nAcademicEmail : "+getAcademicEmail()+
				"\nStudentID : "+getStudentId()+
				"\nSocialSecurityNumber : "+getSocialSecurityNumber()+
				"\nBirthPlace : "+getBirthplace()+
				"\nBirthDay : "+getBirthday().getDate()+"/"+getBirthday().getMonth()+"/"+getBirthday().getYear()+
				"\nUniversityClass : "+getUniversityClass()+
				"\nPersonalEmail : "+getPersonalEmail();
		return message;
	}
	
	public boolean isEqual(Student s) {
		if((s.getAcademicEmail().equals(getAcademicEmail())) && 
				(s.getPersonalEmail().equals(getPersonalEmail())) &&
				(s.getSocialSecurityNumber().equals(getSocialSecurityNumber())) &&
				(s.getStudentId() == getStudentId()))
			return true;
		return false;
	}
	
	public static Comparator<Student> StudentNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
           String StudentName1 = s1.getLastName().toUpperCase();
           String StudentName2 = s2.getLastName().toUpperCase();

           //ascending order
           return StudentName1.compareTo(StudentName2);

        }
    };


    public static Comparator<Student> StudentClassComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
           String StudentClass1 = s1.getUniversityClass().toUpperCase();
           String StudentClass2 = s2.getUniversityClass().toUpperCase();

           //ascending order
           return StudentClass1.compareTo(StudentClass2);
         }
    };
	

}
