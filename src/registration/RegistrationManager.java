package registration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csv.CsvFileManager;

public class RegistrationManager implements CsvFileManager{
	
	private final String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\registration\\registrations.csv";
	
	private ArrayList<Registration> registrationList = new ArrayList<Registration>();
	
	public RegistrationManager() {}
	
	public RegistrationManager(ArrayList<Registration> registrationList) {
		setRegistrationList(registrationList);
	}
	
	public ArrayList<Registration> getRegistrationList() {
		return registrationList;
	}

	public void setRegistrationList(ArrayList<Registration> registrationList) {
		this.registrationList = registrationList;
	}

	@Override
	public void writeCsvFile() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
			if(!getRegistrationList().isEmpty()) {
				for(Registration registration : getRegistrationList())
					buffer.append(registration.getStudent().getStudentId()+","+registration.getCourse().getId()+"\n");
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
	
	public Registration getRegistration(int studentId, int courseId) {
		Registration currentRegistration = new Registration();
		if(!getRegistrationList().isEmpty()) {
			for(Registration registration : getRegistrationList()) {
				if((registration.getStudent().getStudentId() == studentId) && (registration.getCourse().getId() == courseId)) {
					currentRegistration = registration;
					break;
				}
			}
		}
		return currentRegistration;
	}
	
	public void addRegistration(Registration registration) {
		boolean isUnique = true;
		for(Registration currentRegistration : getRegistrationList()) {
			if(currentRegistration.isEqual(registration)) {
				isUnique = false;
				break;
			}
		}
		if(isUnique) {
			getRegistrationList().add(registration);
			writeCsvFile();
		}
	}
	
	public void deleteRegistration(Registration registration) {
		getRegistrationList().remove(registration);
	}


}
