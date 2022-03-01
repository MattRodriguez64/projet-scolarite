package controle;

import java.util.Date;

public class ControleFinale extends Controle {
	private Date dateRattrapage;
	
	public ControleFinale() {}
	
	public ControleFinale(Date dateExamn, String duree, int coeff, Date dateRattrapage) {
		super(dateExamn, duree, coeff);
		setDateRattrapage(dateRattrapage);
	}

	public Date getDateRattrapage() {
		return dateRattrapage;
	}

	public void setDateRattrapage(Date dateRattrapage) {
		this.dateRattrapage = dateRattrapage;
	}
}
