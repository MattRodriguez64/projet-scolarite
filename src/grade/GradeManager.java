package grade;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import csv.CsvFileManager;
import exam.Exam;
import exam.ExamManager;
import person.Student;
import person.StudentManager;
import registration.Registration;
import registration.RegistrationManager;
import course.CourseManager;

public class GradeManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\grade\\grades.csv";
	
	private ArrayList<Grade> gradeList = new ArrayList<Grade>();

	
	public GradeManager() {
		if(getGradeList().isEmpty()) {
			// Filling of the ArrayList if they're empty
		}
	}
	
	public GradeManager(ArrayList<Grade> gradeList) {
		setGradeList(gradeList);
	}
	
	public ArrayList<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(ArrayList<Grade> gradeList) {
		this.gradeList = gradeList;
	}
	

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getGradeList().isEmpty()) {
				for(Grade grade : getGradeList())
					buffer.append(grade.getCourse().getId()+","+grade.getStudent().getStudentId()+","+grade.getExam().getExamId()+","+grade.getGrade()+"\n");
				buffer.flush();
				buffer.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void readCsvFile(Object[] params) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filepath));
			String line;
			String[] lineSplitted;
			
			try {
				while((line = buffer.readLine()) != null) {
					lineSplitted = line.split(",");
					System.out.println(line);
					
					Grade currentGrade = new Grade(Double.parseDouble(lineSplitted[3]), 
							((StudentManager) params[0]).getStudent(Integer.parseInt(lineSplitted[1])), 
							((CourseManager) params[1]).getCourse(Integer.parseInt(lineSplitted[0])),
							((ExamManager) params[2]).getExam(lineSplitted[2]));
					System.out.println(currentGrade.toString());
					getGradeList().add(currentGrade);
				}
				buffer.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addGrade(Grade grade) {
		getGradeList().add(grade);
		writeCsvFile();
	}
	
	public void deleteGrade(Grade grade) {
		getGradeList().remove(grade);
		writeCsvFile();
	}
	
	public void modifyGrade(Grade oldGrade, Grade newGrade) {
		if(oldGrade.isEqual(newGrade)) {
			deleteGrade(oldGrade);
			addGrade(newGrade);
		}
	}
	
	public void allExamsGrade(Exam exam) {
		Double mean = 0d;
		Double sum = 0d;
		int cpt = 0;
		
		System.out.println("ExamID : "+exam.getExamId()+
				"\nDuration : "+exam.getDuration()+
				"\nCoefficient : "+exam.getCoefficient()+
				"\nExaminationDate : "+exam.getExaminationDate()+"\n");
		
		for(Grade currentGrade : getGradeList()) {
			if(currentGrade.getExam().getExamId() == exam.getExamId()) {
				System.out.println("StudentID : " + currentGrade.getStudent().getStudentId() + "- Grade : "+currentGrade.getGrade()+"/20");
				sum += currentGrade.getGrade();
				cpt++;
			}
		}
		mean = sum / (double) cpt;
		System.out.println("Exam mean : " + mean +"/20");
	}
	
	public void allStudentsGrade(Student student, Object[] params) {
		System.out.println("-- STUDENT : "+student.getAcademicEmail()+" --\n");
		for(Registration registration : ((RegistrationManager) params[0]).getRegistrationList()){
			if(student.isEqual(registration.getStudent())) {
				for(Grade currentGrade : getGradeList()) {
					if((currentGrade.getStudent().isEqual(student)) && (registration.getCourse().isEqual(currentGrade.getCourse()))) {
						System.out.println("-- COURSE : "+currentGrade.getCourse().getName()+" --");
						System.out.println("Grade : "+currentGrade.getGrade()+"/20");
					}
				}
			}
		}

	}

}
