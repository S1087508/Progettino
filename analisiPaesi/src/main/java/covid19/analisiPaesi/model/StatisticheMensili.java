package covid19.analisiPaesi.model;

import org.json.simple.JSONArray;

import covid19.analisiPaesi.statistiche.CalcolatoreStatsMensili;

public class StatisticheMensili {
	
	protected Float mediaMese;
	protected Long medianaMese;
	protected Float varianzaMese;
	
	public StatisticheMensili() {
		this.mediaMese = (float) 0;
		this.medianaMese = (long) 0;
		this.varianzaMese = (float) 0;
	}
	
	public StatisticheMensili(JSONArray j, Integer numMese) throws Exception {
		super();
		this.mediaMese = CalcolatoreStatsMensili.mediaMese(j, numMese);
		this.medianaMese = CalcolatoreStatsMensili.medianaMese(j, numMese);
		this.varianzaMese = CalcolatoreStatsMensili.varianzaMese(j, numMese);
	}

	public Float getMediaMese() {
		return mediaMese;
	}

	public void setMediaMese(Float mediaMese) {
		this.mediaMese = mediaMese;
	}

	public Long getMedianaMese() {
		return medianaMese;
	}

	public void setMedianaMese(Long medianaMese) {
		this.medianaMese = medianaMese;
	}

	public Float getVarianzaMese() {
		return varianzaMese;
	}

	public void setVarianzaMese(Float varianzaMese) {
		this.varianzaMese = varianzaMese;
	}

}
