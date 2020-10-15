package covid19.analisiPaesi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import covid19.analisiPaesi.database.DatiPaesi;
import covid19.analisiPaesi.gestoreErrori.ErroreDiInput;
import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.gestoreErrori.IntervalloDataErrato;
import covid19.analisiPaesi.gestoreErrori.SettimanaNonSupportata;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.MetaDati;
import covid19.analisiPaesi.model.Statistiche;
import covid19.analisiPaesi.statistiche.CalcolatoreStatistiche;

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
		public ArrayList<ArrayList<Dati>> ottieniDati() {
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
		
		@RequestMapping(value = "/statSettimanaItalia", method = RequestMethod.POST)
		public ArrayList<Statistiche> getStatsSettimanaItalia(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<Statistiche> statsSettimanaliItalia = new ArrayList<Statistiche>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatistiche.mediaSettimanaArray(DatiPaesi.obj1, statsSettimanaliItalia , numSettimana);
			return statsSettimanaliItalia;
		}
		
		@RequestMapping(value = "/statSettimanaGermania", method = RequestMethod.POST)
		public ArrayList<Statistiche> getStatsSettimanaGermania(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<Statistiche> statsSettimanaliGermania = new ArrayList<Statistiche>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatistiche.mediaSettimanaArray(DatiPaesi.obj2, statsSettimanaliGermania , numSettimana);
			return statsSettimanaliGermania;
		}
		
		@RequestMapping(value = "/statSettimanaBelgio", method = RequestMethod.POST)
		public ArrayList<Statistiche> getStatsSettimanaBelgio(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<Statistiche> statsSettimanaliBelgio = new ArrayList<Statistiche>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatistiche.mediaSettimanaArray(DatiPaesi.obj1, statsSettimanaliBelgio , numSettimana);
			return statsSettimanaliBelgio;
		}
	}
	

