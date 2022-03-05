package exam;

import java.util.Date;

public class PracticalWork extends Exam{
	
	private int workstationId;
	
	public PracticalWork() {}
	
	public PracticalWork(Date examinationDate, String duration, int coefficient, int workstationId) {
		super(examinationDate, duration, coefficient);
		setWorkstationId(workstationId);
	}

	public int getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(int workstationId) {
		this.workstationId = workstationId;
	}

}
