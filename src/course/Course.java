package course;

import person.Teacher;

public class Course {
	
	private int id;
	private String name;
	private Teacher teacher;
	
	public Course() {}
	
	public Course(int id, String name, Teacher teacher) {
		setId(id);
		setName(name);
		setTeacher(teacher);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String toString() {
		String message;
		message = "Course : \n CourseID : "+getId()+"\n Name : "+getName()+"\n Teacher Email : "+getTeacher().getAcademicEmail();
		return message;
	}
	
	public boolean isEqual(Course c) {
		if(c.getId() == getId()) {
			return true;
		}
		return false;
	}
}
