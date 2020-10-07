package modello;

import java.util.Date;

/**
 * 
 * @author Rumy
 *
 */

public class Dati {
	
	protected String nomePaese;
	protected Integer ricoveri;
	protected Date dataInizio;
	protected Date dataFine;
	protected Date dataCorrente;
	
	//costruttore di default
	public Dati() {
		this.nomePaese = null;
		this.ricoveri = 0;
		this.dataInizio = null;
		this.dataFine = null;
		this.dataCorrente = null;
	}

	//costruttore
	public Dati(String nomePaese, Integer ricoveri, Date dataInizio, Date dataFine, Date dataCorrente) {
		super();
		this.nomePaese = nomePaese;
		this.ricoveri = ricoveri;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.dataCorrente = dataCorrente;
	}

	//getters e setters
	public String getNomePaese() {
		return nomePaese;
	}

	public void setNomePaese(String nomePaese) {
		this.nomePaese = nomePaese;
	}

	public Integer getRicoveri() {
		return ricoveri;
	}

	public void setRicoveri(Integer ricoveri) {
		this.ricoveri = ricoveri;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataCorrente() {
		return dataCorrente;
	}

	public void setDataCorrente(Date dataCorrente) {
		this.dataCorrente = dataCorrente;
	}
	
	
	
}