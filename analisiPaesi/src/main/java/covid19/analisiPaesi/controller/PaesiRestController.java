package covid19.analisiPaesi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import covid19.analisiPaesi.database.DatiPaesi;
import covid19.analisiPaesi.modello.Dati;
import covid19.analisiPaesi.modello.MetaDati;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<ArrayList<MetaDati>> getMetaDati() {
		return new ResponseEntity<ArrayList<MetaDati>>(DatiPaesi.getArrayMetaDati(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dati", method=RequestMethod.GET)
	public ArrayList<ArrayList<Dati>> getDataWithGet() {
		return DatiPaesi.getDati();
	}
	
	@RequestMapping("/datiPeriodoItalia")
	public ArrayList<ArrayList<Dati>> getDatiMeseItalia(@RequestParam(name = "dataInizio", defaultValue = "2020-03-01" ) String dataInizio, @RequestParam(name = "dataFine", defaultValue = "2020-05-31") String dataFine) throws MalformedURLException {
		return DatiPaesi.getPeriodoItalia(dataInizio, dataFine);
	}
	
	//@RequestMapping(value = "/italia", method = RequestMethod.GET)
	//public ResponseEntity<ArrayList<Dati>> getDati(JSONArray obj1, ArrayList<Dati> italia) {
		//return new ResponseEntity<ArrayList<Dati>>(DatiPaesi.getArrayDati(obj1, italia), HttpStatus.OK);
	}

	//@RequestMapping(value = "/dati", method = RequestMethod.GET)
	//public ResponseEntity<ArrayList<Dati>> getDati(@RequestBody JSONObject body) {
		//System.out.println(body);
		//String datauno =(String) body.get("data1");
		//System.out.println(datauno);
		//return new ResponseEntity<ArrayList<Dati>>(DatiPaesi.getArrayDati(), HttpStatus.OK);
	
	
	

