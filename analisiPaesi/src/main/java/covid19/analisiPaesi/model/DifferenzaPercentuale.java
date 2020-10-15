package covid19.analisiPaesi.model;

public class DifferenzaPercentuale {
	
	protected Float diffPercentuale;

	public DifferenzaPercentuale() {
		this.diffPercentuale = (float) 0;
	}
	
	public DifferenzaPercentuale(Float diffPercentuale) {
		super();
		this.diffPercentuale = diffPercentuale;
	}

	public Float getDiffPercentuale() {
		return diffPercentuale;
	}

	public void setDiffPercentuale(Float diffPercentuale) {
		this.diffPercentuale = diffPercentuale;
	}
}
