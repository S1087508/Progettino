package covid19.analisiPaesi.model;

import org.json.simple.JSONArray;

import covid19.analisiPaesi.statistiche.CalcolatoreStatistiche;

public class Statistiche {
	protected Float mediaSettimana;
	protected Float mediaMese;
	protected Float medianaSettimana;
	protected Float medianaMese;
	protected Float varianzaSettimana;
	protected Float varianzaMese;
	protected Float diffPercentuale;
	
	//costruttore di default
	public Statistiche() {
		this.mediaSettimana = (float) 0;
		this.mediaMese = (float) 0;
		this.medianaSettimana = (float) 0;
		this.medianaMese = (float) 0;
		this.varianzaSettimana = (float) 0;
		this.varianzaMese = (float) 0;
		this.diffPercentuale = (float) 0;
	}
	
	public Statistiche(Float mediaSettimana, Float mediaMese, Float medianaSettimana, Float medianaMese,
			Float varianzaSettimana, Float varianzaMese, Float diffPercentuale) {
		super();
		this.mediaSettimana = mediaSettimana;
		this.mediaMese = mediaMese;
		this.medianaSettimana = medianaSettimana;
		this.medianaMese = medianaMese;
		this.varianzaSettimana = varianzaSettimana;
		this.varianzaMese = varianzaMese;
		this.diffPercentuale = diffPercentuale;
	}
	
	public Statistiche(JSONArray j, Integer numSettimana, Integer numMese) throws Exception {
		super();
		this.mediaSettimana = CalcolatoreStatistiche.mediaSettimana(j, numSettimana);
		this.mediaMese = mediaMese;
		this.medianaSettimana = medianaSettimana;
		this.medianaMese = medianaMese;
		this.varianzaSettimana = varianzaSettimana;
		this.varianzaMese = varianzaMese;
		this.diffPercentuale = diffPercentuale;
	}

	public Float getMediaSettimana() {
		return mediaSettimana;
	}

	public void setMediaSettimana(Float mediaSettimana) {
		this.mediaSettimana = mediaSettimana;
	}

	public Float getMediaMese() {
		return mediaMese;
	}

	public void setMediaMese(Float mediaMese) {
		this.mediaMese = mediaMese;
	}

	public Float getMedianaSettimana() {
		return medianaSettimana;
	}

	public void setMedianaSettimana(Float medianaSettimana) {
		this.medianaSettimana = medianaSettimana;
	}

	public Float getMedianaMese() {
		return medianaMese;
	}

	public void setMedianaMese(Float medianaMese) {
		this.medianaMese = medianaMese;
	}

	public Float getVarianzaSettimana() {
		return varianzaSettimana;
	}

	public void setVarianzaSettimana(Float varianzaSettimana) {
		this.varianzaSettimana = varianzaSettimana;
	}

	public Float getVarianzaMese() {
		return varianzaMese;
	}

	public void setVarianzaMese(Float varianzaMese) {
		this.varianzaMese = varianzaMese;
	}

	public Float getDiffPercentuale() {
		return diffPercentuale;
	}

	public void setDiffPercentuale(Float diffPercentuale) {
		this.diffPercentuale = diffPercentuale;
	}
}