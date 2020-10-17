package covid19.analisiPaesi.model;

import org.json.simple.JSONArray;

import covid19.analisiPaesi.statistiche.CalcolatoreStatsSettimanali;

/**
 * Classe che contiene la media, la mediana e la varianza dei ricoverati
 * calcolate in una settimana.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class StatisticheSettimanali {

	protected Float mediaSettimana;
	protected Long medianaSettimana;
	protected Float varianzaSettimana;

	// costruttore di default
	public StatisticheSettimanali() {
		this.mediaSettimana = (float) 0;
		this.medianaSettimana = (long) 0;
		this.varianzaSettimana = (float) 0;
	}

	public StatisticheSettimanali(JSONArray j, Integer numSettimana) throws Exception {
		super();
		this.mediaSettimana = CalcolatoreStatsSettimanali.mediaSettimana(j, numSettimana);
		this.medianaSettimana = CalcolatoreStatsSettimanali.medianaSettimana(j, numSettimana);
		this.varianzaSettimana = CalcolatoreStatsSettimanali.varianzaSettimana(j, numSettimana);
	}

	public Float getMediaSettimana() {
		return mediaSettimana;
	}

	public void setMediaSettimana(Float mediaSettimana) {
		this.mediaSettimana = mediaSettimana;
	}

	public Long getMedianaSettimana() {
		return medianaSettimana;
	}

	public void setMedianaSettimana(Long medianaSettimana) {
		this.medianaSettimana = medianaSettimana;
	}

	public Float getVarianzaSettimana() {
		return varianzaSettimana;
	}

	public void setVarianzaSettimana(Float varianzaSettimana) {
		this.varianzaSettimana = varianzaSettimana;
	}
}