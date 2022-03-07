package exam;

import java.util.Date;

public class Exam {

	private String examId;
	private Date examinationDate;
	private String duration;
	private int coefficient;
	
	public Exam() {}
	
	public Exam(String examId, Date examinationDate, String duration, int coefficient) {
		setExamId(examId);
		setExaminationDate(examinationDate);
		setDuration(duration);
		setCoefficient(coefficient);
	}
	
	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	@SuppressWarnings("deprecation")
	public String toString() {
		String message;
		message = "Exam : \nExamID: "+getExamId()+"\nExaminationDate : "+
		getExaminationDate().getDate()+"/"+getExaminationDate().getMonth()+"/"+getExaminationDate().getYear()+
		"\nDuration"+getDuration()+"\n"+getCoefficient();
		return message;
	}
	
	public boolean isEqual(Exam exam) {
		if(exam.getExamId() == getExamId())
			return true;
		return false;
	}
}
