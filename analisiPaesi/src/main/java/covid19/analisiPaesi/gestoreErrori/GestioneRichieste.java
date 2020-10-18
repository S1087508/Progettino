package covid19.analisiPaesi.gestoreErrori;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.tags.Param;
import covid19.analisiPaesi.controller.*;

/**
 * Sottoclasse che gestisce le eccezioni lanciate dal controller.
 * 
 * @author Rumeysa Nur Gulesin
 */
@ControllerAdvice
public class GestioneRichieste extends Exception {

	/**
	 * Gestisce l'eccezione dovuta al mancato inserimento di un parametro sul
	 * Client.
	 * 
	 * @return la stringa "Paramentro mancante.".
	 */

	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<String> gestoreParametro(MissingServletRequestParameterException ex) {
		return new ResponseEntity<String>("Parametro mancante.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'assenza di parametri.
	 * 
	 * @return la stringa "Parametro mancante.".
	 */

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<String> gestoreParametro(NullPointerException ex) {
		return new ResponseEntity<String>("Parametro mancante.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'inserimento di un intervallo di tempo, da
	 * parte dell'utente, non supportata dal programma.
	 * 
	 * @return la stringa "Intervallo di tempo non supportato: inserire intervalli
	 *         di tempo compresi fra il 2020-03-01 e il 2020-05-31.".
	 */

	@ExceptionHandler(value = { IntervalloDataErrato.class })
	public ResponseEntity<String> gestoreIntervalloData(IntervalloDataErrato ex) {
		return new ResponseEntity<String>(
				"Intervallo di tempo non supportato: inserire intervalli di tempo compresi fra il 2020-03-01 e il 2020-05-31.",
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'inserimento, da parte dell'utente, di una
	 * data di fine periodo antecedente alla data di inizio periodo.
	 * 
	 * @return la stringa "dataInizio deve essere antecedente a dataFine.".
	 */

	@ExceptionHandler(value = { ErroreDiInput.class })
	public ResponseEntity<String> gestoreOrdineParametri(ErroreDiInput ex) {
		return new ResponseEntity<String>("dataInizio deve essere antecedente a dataFine.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'inserimento, da parte dell'utente, di un
	 * numero di settimana non supportato dal programma.
	 * 
	 * @return la stringa "Inserire un numero intero compreso tra 1 e 13.".
	 */
	@ExceptionHandler(value = { SettimanaNonSupportata.class })
	public ResponseEntity<String> gestoreNumeroSettimana(SettimanaNonSupportata ex) {
		return new ResponseEntity<String>("Inserire un numero intero compreso tra 1 e 13.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'inserimento, da parte dell'utente, di un
	 * numero di mese non supportato dal programma.
	 * 
	 * @returna la stringa "Inserire un numero intero compreso tra 1 e 3.".
	 */
	@ExceptionHandler(value = { MeseNonSupportato.class })
	public ResponseEntity<String> gestoreNumeroMese(MeseNonSupportato ex) {
		return new ResponseEntity<String>("Inserire un numero intero compreso tra 1 e 3.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gestisce l'eccezione dovuta all'inserimento di una data scritta in un formato
	 * non supportato dal programma.
	 * 
	 * @return la stringa "Inserire una data che rispetti il seguente formato:
	 *         aaaa-MM-ggToo-mm-ss (es. 2020-04-22T00:00:00Z)."
	 */
	@ExceptionHandler(value = { java.text.ParseException.class })
	public ResponseEntity<String> gestoreFormatoData(java.text.ParseException ex) {
		return new ResponseEntity<String>(
				"Inserire una data che rispetti il seguente formato: aaaa-MM-ggToo-mm-ss (es. 2020-04-22T00:00:00Z).",
				HttpStatus.BAD_REQUEST);
	}
}
