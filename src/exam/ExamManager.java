package exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getExamList().isEmpty()) {
				for(Exam exam : getExamList())
					buffer.append(exam.getExamId()+","+exam.getExaminationDate()+","+exam.getDuration()+","+exam.getCoefficient()+"\n");
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
	
	public void addExam(Exam exam) {
		getExamList().add(exam);
		writeCsvFile();
	}
	
	public void deleteExam(Exam exam) {
		getExamList().remove(exam);
		writeCsvFile();
	}


}
