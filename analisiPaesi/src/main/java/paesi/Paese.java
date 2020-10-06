package paesi;

/**
 * 
 * @author Rumy
 *
 */

/*superclasse che verrà estesa con le classi interessate*/
public class Paese {
	
	protected String nome;
	protected Integer ricoveri;
	
	//costruttore
	public Paese(String nome, Integer ricoveri) {
		super();
		this.nome = nome;
		this.ricoveri = ricoveri;
	}
	
	//costruttore di default
	public Paese() {
		this.nome = nome;
		this.ricoveri = ricoveri;
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
	
	
	
}