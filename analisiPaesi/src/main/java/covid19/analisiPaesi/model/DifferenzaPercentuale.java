package covid19.analisiPaesi.model;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import covid19.analisiPaesi.statistiche.CalcolatoreDiffPercentuale;

/**
 * Classe che contiene l'oggetto diffPercentuale che rappresenta la statistica
 * di differenza percentuale.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class DifferenzaPercentuale {

	protected Float diffPercentuale;

	public DifferenzaPercentuale() {
		this.diffPercentuale = (float) 0;
	}

	public DifferenzaPercentuale(JSONArray j1, JSONArray j2, String dataInizio, String dataFine) throws Exception {
		super();
		this.diffPercentuale = CalcolatoreDiffPercentuale.diffPercentualePaesi(j1, j2, dataInizio, dataFine);
		;
	}

	public Float getDiffPercentuale() {
		return diffPercentuale;
	}

	public void setDiffPercentuale(Float diffPercentuale) {
		this.diffPercentuale = diffPercentuale;
	}
}
