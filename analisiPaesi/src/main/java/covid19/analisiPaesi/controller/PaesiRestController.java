package covid19.analisiPaesi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import covid19.analisiPaesi.database.DatiPaesi;
import covid19.analisiPaesi.gestoreErrori.ErroreDiInput;
import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.gestoreErrori.IntervalloDataErrato;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.MetaDati;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
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

		private ArrayList o;


		@RequestMapping(value = "/metadati", method=RequestMethod.GET)
		public ResponseEntity<ArrayList<MetaDati>> getMetaDati() {
			return new ResponseEntity<ArrayList<MetaDati>>(DatiPaesi.getArrayMetaDati(), HttpStatus.OK);
		}
		
		@RequestMapping(value = "/dati", method=RequestMethod.GET)
		public ArrayList<ArrayList<Dati>> getDataWithGet() {
			return DatiPaesi.getDati();
		}
		
		@RequestMapping(value = "/datiPeriodoItalia", method = RequestMethod.POST)
		public ArrayList<Dati> getDatiPeriodoItalia(@RequestParam(name = "dataInizio") String dataInizio, @RequestParam(name = "dataFine") String dataFine) throws Exception {
			if( (FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z"))) || (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z")))) throw new IntervalloDataErrato();
				else if(FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine))) throw new ErroreDiInput();
				return DatiPaesi.getArrayDati(DatiPaesi.obj1, DatiPaesi.DatiItalia, dataInizio, dataFine);
		}
		
		@RequestMapping(value = "/datiPeriodoGermania", method = RequestMethod.POST)
		public ArrayList<Dati> getDatiPeriodoGermania(@RequestParam(name = "dataInizio") String dataInizio, @RequestParam(name = "dataFine") String dataFine) throws Exception {
			if( (FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z"))) || (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z")))) throw new IntervalloDataErrato();
			else if(FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine))) throw new ErroreDiInput();
			return DatiPaesi.getArrayDati(DatiPaesi.obj2, DatiPaesi.DatiGermania, dataInizio, dataFine);
		}
	
	
		@RequestMapping(value = "/datiPeriodoBelgio", method = RequestMethod.POST)
		public ArrayList<Dati> getDatiPeriodoBelgio(@RequestParam(name = "dataInizio") String dataInizio, @RequestParam(name = "dataFine") String dataFine) throws Exception {
			if( (FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z"))) || (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z")))) throw new IntervalloDataErrato();
			else if(FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine))) throw new ErroreDiInput();
			return DatiPaesi.getArrayDati(DatiPaesi.obj3, DatiPaesi.DatiBelgio, dataInizio, dataFine);
		}
	}

	//@RequestMapping(value = "/italia", method = RequestMethod.GET)
	//public ResponseEntity<ArrayList<Dati>> getDati(JSONArray obj1, ArrayList<Dati> italia) {
		//return new ResponseEntity<ArrayList<Dati>>(DatiPaesi.getArrayDati(obj1, italia), HttpStatus.OK);
	

	//@RequestMapping(value = "/dati", method = RequestMethod.GET)
	//public ResponseEntity<ArrayList<Dati>> getDati(@RequestBody JSONObject body) {
		//System.out.println(body);
		//String datauno =(String) body.get("data1");
		//System.out.println(datauno);
		//return new ResponseEntity<ArrayList<Dati>>(DatiPaesi.getArrayDati(), HttpStatus.OK);
	

