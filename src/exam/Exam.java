package exam;

import java.util.Date;

public class Exam {

	private Date examinationDate;
	private String duration;
	private int coefficient;
	
	public Exam() {}
	
	public Exam(Date examinationDate, String duration, int coefficient) {
		setExaminationDate(examinationDate);
		setDuration(duration);
		setCoefficient(coefficient);
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
}
