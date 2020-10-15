package covid19.analisiPaesi.model;

import org.json.simple.JSONArray;

import covid19.analisiPaesi.statistiche.CalcolatoreStatistiche;

public class StatisticheMensili {
	
	protected Float mediaMese;
	protected Float medianaMese;
	protected Float varianzaMese;
	
	public StatisticheMensili() {
		this.mediaMese = (float) 0;
		this.medianaMese = (float) 0;
		this.varianzaMese = (float) 0;
	}
	
	public StatisticheMensili(JSONArray j, Integer numMese) throws Exception {
		super();
		this.mediaMese = CalcolatoreStatistiche.mediaMese(j, numMese);
		this.medianaMese = medianaMese;
		this.varianzaMese = varianzaMese;
	}

	public Float getMediaMese() {
		return mediaMese;
	}

	public void setMediaMese(Float mediaMese) {
		this.mediaMese = mediaMese;
	}

	public Float getMedianaMese() {
		return medianaMese;
	}

	public void setMedianaMese(Float medianaMese) {
		this.medianaMese = medianaMese;
	}

	public Float getVarianzaMese() {
		return varianzaMese;
	}

	public void setVarianzaMese(Float varianzaMese) {
		this.varianzaMese = varianzaMese;
	}

}
