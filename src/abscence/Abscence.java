package abscence;

import java.util.Date;

import cours.Cours;
import personne.Etudiant;

public class Abscence {
	private Date dateAbscence;
	private String motif;
	private Etudiant etudiant;
	private Cours cours;
	
	public Abscence() {}
	public Abscence(Date dateAbscence, String motif, Etudiant etudiant, Cours cours) {
		setDateAbscence(dateAbscence);
		setMotif(motif);
		setEtudiant(etudiant);
		setCours(cours);
	}
	public Date getDateAbscence() {
		return dateAbscence;
	}
	public void setDateAbscence(Date dateAbscence) {
		this.dateAbscence = dateAbscence;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
}
