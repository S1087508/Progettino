package modello;

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
	protected String codiceCitta;
	protected Double latitudine;
	protected Double longitudine;
	protected Integer casi;
	protected String stato;
	protected Date dataCorrente;
	
	//costruttore di default
	public Dati() {
		this.nomePaese = null;
		this.codicePaese = null;
		this.provincia = null;
		this.codiceCitta = null;
		this.latitudine = (double) 0;
		this.longitudine = (double) 0;
		this.casi = 0;
		this.stato = null;
		this.dataCorrente = null;
	}

	public Dati(String nomePaese, String codicePaese, String provincia, String codiceCitta, Double latitudine,
			Double longitudine, Integer casi, String stato, Date dataCorrente) {
		super();
		this.nomePaese = nomePaese;
		this.codicePaese = codicePaese;
		this.provincia = provincia;
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

	public String getCodiceCitta() {
		return codiceCitta;
	}

	public void setCodiceCitta(String codiceCitta) {
		this.codiceCitta = codiceCitta;
	}

	public Double getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}

	public Double getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}

	public Integer getCasi() {
		return casi;
	}

	public void setCasi(Integer casi) {
		this.casi = casi;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataCorrente() {
		return dataCorrente;
	}

	public void setDataCorrente(Date dataCorrente) {
		this.dataCorrente = dataCorrente;
	}
	
	
}