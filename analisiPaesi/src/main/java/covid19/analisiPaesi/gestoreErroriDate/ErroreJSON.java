package covid19.analisiPaesi.gestoreErroriDate;

public class ErroreJSON {
	
	private String messaggio; 	
	private int codiceErrore;
	private String nomeErrore;
	
	public ErroreJSON(String messaggio, int codiceErrore, String nomeErrore) {
		super();
		this.messaggio = messaggio;
		this.codiceErrore = codiceErrore;
		this.nomeErrore = nomeErrore;
	}
	
	public ErroreJSON() {
		super();
		this.messaggio = "";
		this.codiceErrore = 0;
		this.nomeErrore = "";
	}
	
	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public int getCodiceErrore() {
		return codiceErrore;
	}

	public void setCodiceErrore(int codiceErrore) {
		this.codiceErrore = codiceErrore;
	}

	public String getNomeErrore() {
		return nomeErrore;
	}

	public void setNomeErrore(String nomeErrore) {
		this.nomeErrore = nomeErrore;
	}	
}

