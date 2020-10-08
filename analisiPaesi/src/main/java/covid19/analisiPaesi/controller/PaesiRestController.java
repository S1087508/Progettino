package covid19.analisiPaesi.controller;

import org.springframework.web.bind.annotation.RestController;

import covid19.analisiPaesi.database.DatiPaesi;
import covid19.analisiPaesi.modello.Dati;
import covid19.analisiPaesi.modello.MetaDati;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**§
 * 
 * @author Rumy
 *
 */

@RestController
public class PaesiRestController { 
	@RequestMapping(value = "/metadati", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<MetaDati>> getMetaDati(){
		return new ResponseEntity<ArrayList<MetaDati>>(DatiPaesi.getArrayMetaDati(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dati", method=RequestMethod.GET)
	public ArrayList<Dati> getDati() {
		
		return DatiPaesi.getArrayDati();
	}
}

	
	

