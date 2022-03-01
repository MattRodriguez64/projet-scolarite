package note;

import cours.Cours;
import personne.Etudiant;

public class Note {
	private double note;
	private Etudiant etudiant;
	private Cours cours;
	
	public Note() {}
	
	public Note(double note, Etudiant etudiant, Cours cours) {
		setNote(note);
		setEtudiant(etudiant);
		setCours(cours);
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		if((note >= 0) && (note <= 20))
			this.note = note;
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
