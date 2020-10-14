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
}
