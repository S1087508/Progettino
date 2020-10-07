package modello;

import java.util.Date;

/**
 * 
 * @author Rumy
 *
 */

/*superclasse che verrà estesa con le classi interessate*/
public class Dati {
	
	protected String nome;
	protected Integer ricoveri;
	protected Date dataInizio;
	protected Date dataFine;
	
	//costruttore
	public Dati(String nome, Integer ricoveri, Date dataInizio, Date dataFine) {
		super();
		this.nome = nome;
		this.ricoveri = ricoveri;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}
	
	//costruttore di default
	public Dati() {
		this.nome = null;
		this.ricoveri = null;
		this.dataInizio = null;
		this.dataFine = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	
}