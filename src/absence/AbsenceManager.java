package absence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import course.CourseManager;
import csv.CsvFileManager;
import person.StudentManager;

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

	@SuppressWarnings("deprecation")
	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getAbsenceList().isEmpty()) {
				for(Absence absence : getAbsenceList())
					buffer.append(absence.getStudent().getStudentId()+","+
				absence.getCourse().getId()+","+
							absence.getAbsenceDate().getDate()+"-"+absence.getAbsenceDate().getMonth()+"-"+absence.getAbsenceDate().getYear()+","+
				absence.getReason()+"\n");
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
					String[] dateSplitted = lineSplitted[2].split("-");
					System.out.println(line);
					
					Absence currentAbsence = new Absence(new Date(Integer.parseInt(dateSplitted[2]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(lineSplitted[0]), 0, 0),
							lineSplitted[3], 
							((StudentManager) params[0]).getStudent(Integer.parseInt(lineSplitted[0])), 
							((CourseManager) params[1]).getCourse(Integer.parseInt(lineSplitted[1])));
					System.out.println(currentAbsence.toString());
					getAbsenceList().add(currentAbsence);
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
