package controle;

import java.util.Date;

public class TravailPratique extends Controle{
	private String idPosteTravail;
	
	public TravailPratique() {}
	
	public TravailPratique(Date dateExamn, String duree, int coeff, String idPosteTravail) {
		super(dateExamn, duree, coeff);
		setIdPosteTravail(idPosteTravail);
	}

	public String getIdPosteTravail() {
		return idPosteTravail;
	}

	public void setIdPosteTravail(String idPosteTravail) {
		this.idPosteTravail = idPosteTravail;
	}
	
}
