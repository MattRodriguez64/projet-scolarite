package controle;

import java.util.Date;

public class Controle {
	private Date dateExam;
	private String duree;
	private int coeff;
	
	public Controle() {}
	
	public Controle(Date dateExam, String duree, int coeff) {
		setDateExam(dateExam);
		setDuree(duree);
		setCoeff(coeff);
	}

	public Date getDateExam() {
		return dateExam;
	}

	public void setDateExam(Date dateExam) {
		this.dateExam = dateExam;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
}
