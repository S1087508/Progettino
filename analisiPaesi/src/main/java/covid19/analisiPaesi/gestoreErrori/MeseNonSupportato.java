package covid19.analisiPaesi.gestoreErrori;

/**
 * Sottoclasse che estende GestioneRichieste. Permette di lanciare un'eccezione
 * quando l'utente inserisce un numero di mese non supportato dal programma.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */

public class MeseNonSupportato extends GestioneRichieste {

	public MeseNonSupportato() {
		super();
		System.out.println("Inserire un numero intero compreso tra 1 e 3");
	}
}
