package covid19.analisiPaesi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import covid19.analisiPaesi.database.DatiPaesi;
import covid19.analisiPaesi.gestoreErrori.ErroreDiInput;
import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.gestoreErrori.IntervalloDataErrato;
import covid19.analisiPaesi.gestoreErrori.MeseNonSupportato;
import covid19.analisiPaesi.gestoreErrori.SettimanaNonSupportata;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.MetaDati;
import covid19.analisiPaesi.model.StatisticheMensili;
import covid19.analisiPaesi.model.StatisticheSettimanali;
import covid19.analisiPaesi.statistiche.CalcolatoreStatsMensili;
import covid19.analisiPaesi.statistiche.CalcolatoreStatsSettimanali;

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
		public ArrayList<StatisticheSettimanali> getStatsSettimanaItalia(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<StatisticheSettimanali> statsSettimanaliItalia = new ArrayList<StatisticheSettimanali>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatsSettimanali.mediaSettimanaArray(DatiPaesi.obj1, statsSettimanaliItalia , numSettimana);
			return statsSettimanaliItalia;
		}
		
		@RequestMapping(value = "/statSettimanaGermania", method = RequestMethod.POST)
		public ArrayList<StatisticheSettimanali> getStatsSettimanaGermania(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<StatisticheSettimanali> statsSettimanaliGermania = new ArrayList<StatisticheSettimanali>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatsSettimanali.mediaSettimanaArray(DatiPaesi.obj2, statsSettimanaliGermania , numSettimana);
			return statsSettimanaliGermania;
		}
		
		@RequestMapping(value = "/statSettimanaBelgio", method = RequestMethod.POST)
		public ArrayList<StatisticheSettimanali> getStatsSettimanaBelgio(@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
			ArrayList<StatisticheSettimanali> statsSettimanaliBelgio = new ArrayList<StatisticheSettimanali>();
			if( numSettimana < 1 || numSettimana > 13 ) throw new SettimanaNonSupportata();
			else CalcolatoreStatsSettimanali.mediaSettimanaArray(DatiPaesi.obj3, statsSettimanaliBelgio , numSettimana);
			return statsSettimanaliBelgio;
		}
		
		@RequestMapping(value = "/statMeseItalia", method = RequestMethod.POST)
		public ArrayList<StatisticheMensili> getStatsMeseItalia(@RequestParam(name = "Mese") Integer numMese) throws Exception {
			ArrayList<StatisticheMensili> statsMeseItalia = new ArrayList<StatisticheMensili>();
			if( numMese < 1 || numMese > 3 ) throw new MeseNonSupportato();
			else {
				CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj1, statsMeseItalia , numMese);
			}
			return statsMeseItalia;
		}
		
		@RequestMapping(value = "/statMeseGermania", method = RequestMethod.POST)
		public ArrayList<StatisticheMensili> getStatsMeseGermania(@RequestParam(name = "Mese") Integer numMese) throws Exception {
			ArrayList<StatisticheMensili> statsMeseGermania = new ArrayList<StatisticheMensili>();
			if( numMese < 1 || numMese > 3 ) throw new MeseNonSupportato();
			else {
				CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj2, statsMeseGermania , numMese);
			}
			return statsMeseGermania;
		}
		
		@RequestMapping(value = "/statMeseBelgio", method = RequestMethod.POST)
		public ArrayList<StatisticheMensili> getStatsMeseBelgio(@RequestParam(name = "Mese") Integer numMese) throws Exception {
			ArrayList<StatisticheMensili> statsMeseBelgio = new ArrayList<StatisticheMensili>();
			if( numMese < 1 || numMese > 3 ) throw new MeseNonSupportato();
			else {
				CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj3, statsMeseBelgio , numMese);
			}
			return statsMeseBelgio;
		}
	}
	

