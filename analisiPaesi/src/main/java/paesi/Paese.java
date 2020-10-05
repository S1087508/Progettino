package paesi;

/**
 * 
 * @author Rumy
 *
 */

/*superclasse che verrà estesa con le classi interessate*/
public class Paese {
	
	protected Integer casi;
	protected Integer guarigioni;
	protected Integer decessi;
	
	/**
	 * 
	 * @param nome
	 * @param casi
	 * @param guarigioni
	 * @param decessi
	 */
	
	public Paese(String nome, Integer casi, Integer guarigioni, Integer decessi) {
		super();
		this.casi = casi;
		this.guarigioni = guarigioni;
		this.decessi = decessi;
	}
	
    /*costruttore di default*/
	public Paese() {
		this.casi = null;
		this.guarigioni = null;
		this.decessi = null;
	}
	
	/**
	 * 
	 * @return
	*/
	
	/*getters e setters*/
	public Integer getCasi() {
		return casi;
	}

	public void setCasi(Integer casi) {
		this.casi = casi;
	}

	public Integer getGuarigioni() {
		return guarigioni;
	}

	public void setGuarigioni(Integer guarigioni) {
		this.guarigioni = guarigioni;
	}

	public Integer getDecessi() {
		return decessi;
	}

	public void setDecessi(Integer decessi) {
		this.decessi = decessi;
	}
	
	

}


