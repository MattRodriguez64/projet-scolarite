package controle;

import java.util.ArrayList;
import java.util.Date;

import personne.Etudiant;

public class Projet extends Controle{
	
	private ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
	
	public Projet() {}
	
	public Projet(Date dateExam, String duree, int coeff, ArrayList<Etudiant> listeEtudiants) {
		super(dateExam, duree, coeff);
		setListeEtudiants(listeEtudiants);
	}

	public ArrayList<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

}
