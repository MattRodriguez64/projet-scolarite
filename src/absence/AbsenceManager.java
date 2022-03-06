package absence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import csv.CsvFileManager;

public class AbsenceManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\absence\\absences.csv";
	
	private ArrayList<Absence> absenceList = new ArrayList<Absence>();
	
	public AbsenceManager() {}
	
	public AbsenceManager(ArrayList<Absence> absenceList) {
		setAbsenceList(absenceList);
	}
	
	public ArrayList<Absence> getAbsenceList() {
		return absenceList;
	}

	public void setAbsenceList(ArrayList<Absence> absenceList) {
		this.absenceList = absenceList;
	}

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getAbsenceList().isEmpty()) {
				for(Absence absence : getAbsenceList())
					buffer.append(absence.getStudent().getStudentId()+","+
				absence.getCourse().getId()+","+
							absence.getAbsenceDate()+","+
				absence.getReason()+"\n");
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
	
	public Absence getAbsence(Date absenceDate, int studentId) {
		Absence currentAbsence = new Absence();
		if(!getAbsenceList().isEmpty()) {
			for(Absence absence : getAbsenceList()) {
				if((absence.getAbsenceDate().equals(absenceDate)) && (absence.getStudent().getStudentId() == studentId)) {
					currentAbsence = absence;
					break;
				}
			}
		}
		return currentAbsence;
	}
	
	public void addAbsence(Absence absence) {
		getAbsenceList().add(absence);
		writeCsvFile();
	}
	
	public void modifyAbsence(Absence oldAbsence, Absence newAbsence) {
		if(oldAbsence.isEqual(newAbsence)) {
			deleteAbsence(oldAbsence);
			addAbsence(newAbsence);
		}
	}
	
	public void deleteAbsence(Absence absence) {
		getAbsenceList().remove(absence);
		writeCsvFile();
	}


}
