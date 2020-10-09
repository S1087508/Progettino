package covid19.analisiPaesi.modello;

import java.util.Date;

/**
 * 
 * @author Rumy
 *
 */

public class Dati {
	
	protected String nomePaese;
	protected String codicePaese;
	protected String provincia;
	protected String citta;
	protected String codiceCitta;
	protected String latitudine;
	protected String longitudine;
	protected Long casi;
	protected String stato;
	protected String dataCorrente;
	
	//costruttore di default
	public Dati() {
		this.nomePaese = null;
		this.codicePaese = null;
		this.provincia = null;
		this.citta = null;
		this.codiceCitta = null;
		this.latitudine = null;
		this.longitudine = null;
		this.casi = (long) 0;
		this.stato = null;
		this.dataCorrente = null;
	}

	public Dati(String nomePaese, String codicePaese, String provincia,String citta, String codiceCitta, String latitudine,
			String longitudine, Long casi, String stato, String dataCorrente) {
		super();
		this.nomePaese = nomePaese;
		this.codicePaese = codicePaese;
		this.provincia = provincia;
		this.citta = citta;
		this.codiceCitta = codiceCitta;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.casi = casi;
		this.stato = stato;
		this.dataCorrente = dataCorrente;
	}

	public String getNomePaese() {
		return nomePaese;
	}

	public void setNomePaese(String nomePaese) {
		this.nomePaese = nomePaese;
	}

	public String getCodicePaese() {
		return codicePaese;
	}

	public void setCodicePaese(String codicePaese) {
		this.codicePaese = codicePaese;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodiceCitta() {
		return codiceCitta;
	}

	public void setCodiceCitta(String codiceCitta) {
		this.codiceCitta = codiceCitta;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public Long getCasi() {
		return casi;
	}

	public void setCasi(Long casi) {
		this.casi = casi;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getDataCorrente() {
		return dataCorrente;
	}

	public void setDataCorrente(String dataCorrente) {
		this.dataCorrente = dataCorrente;
	}
	
	
}