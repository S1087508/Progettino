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

@ControllerAdvice
public class GestioneRichieste extends Exception {
	
	@ExceptionHandler(value = {MissingServletRequestParameterException.class})
	public ResponseEntity<String> gestoreParametro(MissingServletRequestParameterException ex){
		return new ResponseEntity<String>("Parametro mancante.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {IntervalloDataErrato.class})
	public ResponseEntity<String> gestoreIntervalloData(IntervalloDataErrato ex){
		return new ResponseEntity<String>("Intervallo di tempo non supportato: inserire intervalli di tempo compresi fra il 2020-03-01 e il 2020-05-31.", HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(value = {ErroreDiInput.class})
	public ResponseEntity<String> gestoreOrdineParametri(ErroreDiInput ex){
		return new ResponseEntity<String>("dataInizio deve essere antecedente a dataFine.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {SettimanaNonSupportata.class})
	public ResponseEntity<String> gestoreNumeroSettimana(SettimanaNonSupportata ex){
		return new ResponseEntity<String>("Inserire un numero intero compreso tra 1 e 13.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {MeseNonSupportato.class})
	public ResponseEntity<String> gestoreNumeroMese(MeseNonSupportato ex){
		return new ResponseEntity<String>("Inserire un numero intero compreso tra 1 e 3.", HttpStatus.BAD_REQUEST);
	}
}
