package personne;

public class Personne {
	private String nom;
	private String prenom;
	private String emailUniversitaire;
	
	public Personne() {}
	
	public Personne(String nom, String prenom, String emailUniversitaire) {
		setNom(nom);
		setPrenom(prenom);
		setEmailUniversitaire(emailUniversitaire);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmailUniversitaire() {
		return emailUniversitaire;
	}
	public void setEmailUniversitaire(String emailUniversitaire) {
		this.emailUniversitaire = emailUniversitaire;
	}
	
}
