package covid19.analisiPaesi.modello;

public class Statistiche {
	protected Float media;
	protected Float mediana;
	protected Float varianza;
	protected Float percentuale;
	
	//costruttore di default
	public Statistiche() {
		this.media = (float) 0;
		this.mediana = (float) 0;
		this.varianza = (float) 0;
		this.percentuale = (float) 0;
	}
	
	//costruttore
	public Statistiche(Float media, Float mediana, Float varianza, Float percentuale) {
		super();
		this.media = media;
		this.mediana = mediana;
		this.varianza = varianza;
		this.percentuale = percentuale;
	}

	public Float getMedia() {
		return media;
	}

	public void setMedia(Float media) {
		this.media = media;
	}

	public Float getMediana() {
		return mediana;
	}

	public void setMediana(Float mediana) {
		this.mediana = mediana;
	}

	public Float getVarianza() {
		return varianza;
	}

	public void setVarianza(Float varianza) {
		this.varianza = varianza;
	}

	public Float getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(Float percentuale) {
		this.percentuale = percentuale;
	}
	
}
