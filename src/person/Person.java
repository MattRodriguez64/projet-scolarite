package person;

public class Person {
	
	private String lastName;
	private String firstName;
	private String academicEmail;
	
	public Person() {}
	
	public Person(String lastName, String firstName, String academicEmail) {
		setLastName(lastName);
		setFirstName(firstName);
		setAcademicEmail(academicEmail);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAcademicEmail() {
		return academicEmail;
	}

	public void setAcademicEmail(String academicEmail) {
		this.academicEmail = academicEmail;
	}
	
}
