package personne;

import java.util.Date;

public class Etudiant extends Personne {
	private int id;
	private int numEtudiant;
	private String numSecuriteSociale;
	private String lieu;
	private Date dateNaissance;
	private String promotion;
	private String emailPerso;
	
	public Etudiant() {}
	
	public Etudiant(String nom, String prenom, String emailUniversitaire, 
			int id, int numEtudiant, String numSecuriteSociale, 
			String lieu, Date dateNaissance, String promotion, String emailPerso) {
		super(nom, prenom, emailUniversitaire);
		setId(id);
		setNumEtudiant(numEtudiant);
		setNumSecuriteSociale(numSecuriteSociale);
		setLieu(lieu);
		setDateNaissance(dateNaissance);
		setPromotion(promotion);
		setEmailPerso(emailPerso);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumEtudiant() {
		return numEtudiant;
	}
	public void setNumEtudiant(int numEtudiant) {
		this.numEtudiant = numEtudiant;
	}
	public String getNumSecuriteSociale() {
		return numSecuriteSociale;
	}
	public void setNumSecuriteSociale(String numSecuriteSociale) {
		this.numSecuriteSociale = numSecuriteSociale;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getEmailPerso() {
		return emailPerso;
	}
	public void setEmailPerso(String emailPerso) {
		this.emailPerso = emailPerso;
	}
	
}

