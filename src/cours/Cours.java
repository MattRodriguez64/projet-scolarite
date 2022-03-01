package cours;

import personne.Enseignant;

public class Cours {
	private int id;
	private String intitule;
	private Enseignant enseignant;
	
	public Cours() {}
	
	public Cours(int id, String intitule, Enseignant enseignant) {
		setId(id);
		setIntitule(intitule);
		setEnseignant(enseignant);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
}
