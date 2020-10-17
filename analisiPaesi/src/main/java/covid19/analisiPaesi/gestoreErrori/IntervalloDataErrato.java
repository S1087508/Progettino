package covid19.analisiPaesi.gestoreErrori;

/**
 * Sottoclasse che estende GestioneRichieste. Permette di lanciare un'eccezione
 * quando l'utente sceglie un intervallo di tempo che supera il range supportato
 * dal programma.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */

public class IntervalloDataErrato extends GestioneRichieste {

	public IntervalloDataErrato() {
		super();
		System.out.println(
				"Intervallo di tempo non supportato: inserire intervalli di tempo compresi fra il 2020-03-01 e il 2020-05-31.");
	}
}
