package inscription;

import cours.Cours;
import personne.Etudiant;

public class Inscription {
	private Etudiant etudiant;
	private Cours cours;
	
	public Inscription() {}
	
	public Inscription(Etudiant etudiant, Cours cours) {
		setEtudiant(etudiant);
		setCours(cours);
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
