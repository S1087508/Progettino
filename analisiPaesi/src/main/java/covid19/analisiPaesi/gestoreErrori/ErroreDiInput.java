package covid19.analisiPaesi.gestoreErrori;

/**
 * Sottoclasse che estende GestioneRichieste. Permette di lanciare un'eccezione
 * quando l'utente sceglie una data di fine periodo antecedente alla data di
 * inizio periodo.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class ErroreDiInput extends GestioneRichieste {

	public ErroreDiInput() {
		super();
		System.out.println("dataInizio deve essere antecedente a dataFine.");
	}

}
