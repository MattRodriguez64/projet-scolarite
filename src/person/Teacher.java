package person;

public class Teacher extends Person{
	
	public Teacher() {}
	
	public Teacher(String lastName, String firstName, String academicEmail) {
		super(lastName, firstName, academicEmail);
	}
	
	public boolean isEqual(Teacher t) {
		if(t.getAcademicEmail().equals(getAcademicEmail()))
			return true;
		return false;
	}

}
