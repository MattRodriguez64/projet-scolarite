package exam;

import java.util.ArrayList;

import csv.CsvFileManager;

public class ExamManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\exam\\exams.csv";
	
	private ArrayList<Exam> examList = new ArrayList<Exam>();
	
	public ExamManager() {}
	
	public ArrayList<Exam> getExamList() {
		return examList;
	}

	public void setExamList(ArrayList<Exam> examList) {
		this.examList = examList;
	}
	
	public void addExam(Exam exam) {
		getExamList().add(exam);
	}

	@Override
	public void writeCsvFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCsvFile(Object[] params) {
		// TODO Auto-generated method stub
		
	}
	
	public Exam getExam(String examId) {
		Exam currentExam = new Exam();
		if(!getExamList().isEmpty()) {
			for(Exam exam : getExamList()) {
				if(exam.getExamId() == examId) {
					currentExam = exam;
					break;
				}
			}
		}
		return currentExam;
	}


}
