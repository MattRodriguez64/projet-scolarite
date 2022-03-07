package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	

	@SuppressWarnings("deprecation")
	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getExamList().isEmpty()) {
				for(Exam exam : getExamList())
					buffer.append(exam.getExamId()+","+exam.getExaminationDate().getDate()+"-"+exam.getExaminationDate().getMonth()+"-"+exam.getExaminationDate().getYear()+","+exam.getDuration()+","+exam.getCoefficient()+"\n");
				buffer.flush();
				buffer.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void readCsvFile(Object[] params) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filepath));
			String line;
			String[] lineSplitted;
			
			try {
				while((line = buffer.readLine()) != null) {
					lineSplitted = line.split(",");
					String[] dateSplitted = lineSplitted[1].split("-");
					System.out.println(line);
					
					Exam currentExam = new Exam(lineSplitted[0], 
							new Date(Integer.parseInt(dateSplitted[2]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(dateSplitted[0]), 0, 0), 
							lineSplitted[2], 
							Integer.parseInt(lineSplitted[3]));
					
					System.out.println(currentExam.toString());
					getExamList().add(currentExam);
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
