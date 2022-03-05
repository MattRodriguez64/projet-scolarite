package exam;

import java.util.Date;

public class FinalExam extends Exam {
	
	private Date catchUpDate;
	
	public FinalExam() {}
	
	public FinalExam(String examId,Date examinationDate, String duration, int coefficient, Date catchUpDate) {
		super(examId, examinationDate, duration, coefficient);
		setCatchUpDate(catchUpDate);
	}

	public Date getCatchUpDate() {
		return catchUpDate;
	}

	public void setCatchUpDate(Date catchUpDate) {
		this.catchUpDate = catchUpDate;
	}

}
