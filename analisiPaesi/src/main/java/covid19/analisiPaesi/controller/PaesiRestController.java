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
import covid19.analisiPaesi.model.DifferenzaPercentuale;
import covid19.analisiPaesi.model.MetaDati;
import covid19.analisiPaesi.model.StatisticheMensili;
import covid19.analisiPaesi.model.StatisticheSettimanali;
import covid19.analisiPaesi.statistiche.CalcolatoreDiffPercentuale;
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

/**
 * Tale classe gestisce tutte le chiamate permesse all'utente attraverso il
 * Client.
 * 
 * @author Rumeysa Nur Gulesin
 */

@RestController
public class PaesiRestController {

	/**
	 * Risponde alla richiesta GET /metadati.
	 * 
	 * @return ArrayList di oggetti di tipo MetaDati.
	 */

	@RequestMapping(value = "/metadati", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MetaDati>> getMetaDati() {
		return new ResponseEntity<ArrayList<MetaDati>>(DatiPaesi.getArrayMetaDati(), HttpStatus.OK);
	}

	/**
	 * Risponde alla richiesta GET /dati.
	 * 
	 * @return ArrayList di oggetti di tipo Dati.
	 */

	@RequestMapping(value = "/dati", method = RequestMethod.GET)
	public ArrayList<ArrayList<Dati>> ottieniDati() {
		return DatiPaesi.getDati();
	}

	/**
	 * Risponde alla richiesta POST /datiPeriodoItalia.
	 * 
	 * @param dataInizio : è la data a partire dalla quale verranno prelevati i
	 *                   dati.
	 * @param dataFine   : è la data entro la quale verranno prelevati i dati.
	 * @return ArrayList di oggetti di tipo Dati, contenente i dati rilevati in
	 *         Italia nel periodo di tempo stabilito dall'utente.
	 * @throws Exception : vengono lanciate delle eccezioni se l'utente inserisce un
	 *                   intervallo di tempo che non rientra in quello permesso
	 *                   (dal 01/03/2020 al 31/05/2020), e se l'utente inserisce una data
	 *                   di fine periodo (dataFine) antecedente alla data di inizio
	 *                   periodo (dataInizio).
	 */

	@RequestMapping(value = "/datiPeriodoItalia", method = RequestMethod.POST)
	public ArrayList<Dati> getDatiPeriodoItalia(@RequestParam(name = "dataInizio") String dataInizio,
			@RequestParam(name = "dataFine") String dataFine) throws Exception {
		if ((FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z")))
				|| (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z"))))
			throw new IntervalloDataErrato();
		else if (FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine)))
			throw new ErroreDiInput();
		return DatiPaesi.getArrayDati(DatiPaesi.obj1, DatiPaesi.DatiItalia, dataInizio, dataFine);
	}

	/**
	 * Risponde alla richiesta POST /datiPeriodoGermania.
	 * 
	 * @param dataInizio : è la data a partire dalla quale verranno prelevati i
	 *                   dati.
	 * @param dataFine   : è la data entro la quale verranno prelevati i dati.
	 * @return ArrayList di oggetti di tipo Dati, contenente i dati rilevati in
	 *         Germania nel periodo di tempo stabilito dall'utente.
	 * @throws Exception : vengono lanciate delle eccezioni se l'utente inserisce un
	 *                   intervallo di tempo che non rientra in quello permesso
	 *                   (2020/03/01 - 2020/05/31), e se l'utente inserisce una data
	 *                   di fine periodo (dataFine) antecedente alla data di inizio
	 *                   periodo (dataInizio).
	 */

	@RequestMapping(value = "/datiPeriodoGermania", method = RequestMethod.POST)
	public ArrayList<Dati> getDatiPeriodoGermania(@RequestParam(name = "dataInizio") String dataInizio,
			@RequestParam(name = "dataFine") String dataFine) throws Exception {
		if ((FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z")))
				|| (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z"))))
			throw new IntervalloDataErrato();
		else if (FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine)))
			throw new ErroreDiInput();
		return DatiPaesi.getArrayDati(DatiPaesi.obj2, DatiPaesi.DatiGermania, dataInizio, dataFine);
	}

	/**
	 * Risponde alla richiesta POST /datiPeriodoBelgio.
	 * 
	 * @param dataInizio : è la data a partire dalla quale verranno prelevati i
	 *                   dati.
	 * @param dataFine   : è la data entro la quale verranno prelevati i dati.
	 * @return ArrayList di oggetti di tipo Dati, contenente i dati rilevati in
	 *         Belgio nel periodo di tempo stabilito dall'utente.
	 * @throws Exception : vengono lanciate delle eccezioni se l'utente inserisce un
	 *                   intervallo di tempo che non rientra in quello permesso
	 *                   (2020/03/01 - 2020/05/31), e se l'utente inserisce una data
	 *                   di fine periodo (dataFine) antecedente alla data di inizio
	 *                   periodo (dataInizio).
	 */

	@RequestMapping(value = "/datiPeriodoBelgio", method = RequestMethod.POST)
	public ArrayList<Dati> getDatiPeriodoBelgio(@RequestParam(name = "dataInizio") String dataInizio,
			@RequestParam(name = "dataFine") String dataFine) throws Exception {
		if ((FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z")))
				|| (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z"))))
			throw new IntervalloDataErrato();
		else if (FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine)))
			throw new ErroreDiInput();
		return DatiPaesi.getArrayDati(DatiPaesi.obj3, DatiPaesi.DatiBelgio, dataInizio, dataFine);
	}

	/**
	 * Risponde alla richiesta POST /statSettimanaItalia.
	 * 
	 * @param numSettimana : è il numero della settimana della quale l'utente vuole
	 *                     conoscere le statistiche.
	 * @return Restituisce un ArrayList di oggetti di tipo StatisticheSettimanali
	 *         che contiene media, mediana e varianza dei ricoverati in Italia; le
	 *         statistiche sono calcolate nella settimana scelta dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di una settimana che non rientra nel range
	 *                   delle 13 settimane consentito dal programmatore.
	 */

	@RequestMapping(value = "/statSettimanaItalia", method = RequestMethod.POST)
	public ArrayList<StatisticheSettimanali> getStatsSettimanaItalia(
			@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
		ArrayList<StatisticheSettimanali> statsSettimanaliItalia = new ArrayList<StatisticheSettimanali>();
		if (numSettimana < 1 || numSettimana > 13)
			throw new SettimanaNonSupportata();
		else
			CalcolatoreStatsSettimanali.getSettimanaArray(DatiPaesi.obj1, statsSettimanaliItalia, numSettimana);
		return statsSettimanaliItalia;
	}

	/**
	 * Risponde alla richiesta POST /statSettimanaGermania.
	 * 
	 * @param numSettimana : è il numero della settimana della quale l'utente vuole
	 *                     conoscere le statistiche.
	 * @return Restituisce un ArrayList di oggetti di tipo StatisticheSettimanali
	 *         che contiene media, mediana e varianza dei ricoverati in Germania; le
	 *         statistiche sono calcolate nella settimana scelta dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di una settimana che non rientra nel range
	 *                   delle 13 settimane consentito dal programmatore.
	 */

	@RequestMapping(value = "/statSettimanaGermania", method = RequestMethod.POST)
	public ArrayList<StatisticheSettimanali> getStatsSettimanaGermania(
			@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
		ArrayList<StatisticheSettimanali> statsSettimanaliGermania = new ArrayList<StatisticheSettimanali>();
		if (numSettimana < 1 || numSettimana > 13)
			throw new SettimanaNonSupportata();
		else
			CalcolatoreStatsSettimanali.getSettimanaArray(DatiPaesi.obj2, statsSettimanaliGermania, numSettimana);
		return statsSettimanaliGermania;
	}

	/**
	 * Risponde alla richiesta POST /statSettimanaBelgio.
	 * 
	 * @param numSettimana : è il numero della settimana della quale l'utente vuole
	 *                     conoscere le statistiche.
	 * @return Restituisce un ArrayList di oggetti di tipo StatisticheSettimanali
	 *         che contiene media, mediana e varianza dei ricoverati in Belgio; le
	 *         statistiche sono calcolate nella settimana scelta dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di una settimana che non rientra nel range
	 *                   delle 13 settimane consentito dal programmatore.
	 */

	@RequestMapping(value = "/statSettimanaBelgio", method = RequestMethod.POST)
	public ArrayList<StatisticheSettimanali> getStatsSettimanaBelgio(
			@RequestParam(name = "Settimana") Integer numSettimana) throws Exception {
		ArrayList<StatisticheSettimanali> statsSettimanaliBelgio = new ArrayList<StatisticheSettimanali>();
		if (numSettimana < 1 || numSettimana > 13)
			throw new SettimanaNonSupportata();
		else
			CalcolatoreStatsSettimanali.getSettimanaArray(DatiPaesi.obj3, statsSettimanaliBelgio, numSettimana);
		return statsSettimanaliBelgio;
	}

	/**
	 * Risponde alla richiesta POST /statMeseItalia.
	 * 
	 * @param numMese : è il numero del mese del quale l'utente vuole conoscere le
	 *                statistiche.
	 * @return Restituisce ArrayList di oggetti di tipo StatisticheMensili che
	 *         contiene media, mediana e varianza dei ricoverati in Italia; le
	 *         statistiche sono calcolate nel mese scelto dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di un mese che non rientra nel range di 3 mesi
	 *                   consentito dal programmatore.
	 */

	@RequestMapping(value = "/statMeseItalia", method = RequestMethod.POST)
	public ArrayList<StatisticheMensili> getStatsMeseItalia(@RequestParam(name = "Mese") Integer numMese)
			throws Exception {
		ArrayList<StatisticheMensili> statsMeseItalia = new ArrayList<StatisticheMensili>();
		if (numMese < 1 || numMese > 3)
			throw new MeseNonSupportato();
		else {
			CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj1, statsMeseItalia, numMese);
		}
		return statsMeseItalia;
	}

	/**
	 * Risponde alla richiesta POST /statMeseGermania.
	 * 
	 * @param numMese : è il numero del mese del quale l'utente vuole conoscere le
	 *                statistiche.
	 * @return Restituisce ArrayList di oggetti di tipo StatisticheMensili che
	 *         contiene media, mediana e varianza dei ricoverati in Germania; le
	 *         statistiche sono calcolate nel mese scelto dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di un mese che non rientra nel range di 3 mesi
	 *                   consentito dal programmatore.
	 */

	@RequestMapping(value = "/statMeseGermania", method = RequestMethod.POST)
	public ArrayList<StatisticheMensili> getStatsMeseGermania(@RequestParam(name = "Mese") Integer numMese)
			throws Exception {
		ArrayList<StatisticheMensili> statsMeseGermania = new ArrayList<StatisticheMensili>();
		if (numMese < 1 || numMese > 3)
			throw new MeseNonSupportato();
		else {
			CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj2, statsMeseGermania, numMese);
		}
		return statsMeseGermania;
	}

	/**
	 * Risponde alla richiesta POST /statMeseBelgio.
	 * 
	 * @param numMese : è il numero del mese del quale l'utente vuole conoscere le
	 *                statistiche.
	 * @return Restituisce ArrayList di oggetti di tipo StatisticheMensili che
	 *         contiene media, mediana e varianza dei ricoverati in Belgio; le
	 *         statistiche sono calcolate nel mese scelto dall'utente.
	 * @throws Exception : lancia un'eccezione quando l'utente richiede le
	 *                   statistiche di un mese che non rientra nel range di 3 mesi
	 *                   consentito dal programmatore.
	 */

	@RequestMapping(value = "/statMeseBelgio", method = RequestMethod.POST)
	public ArrayList<StatisticheMensili> getStatsMeseBelgio(@RequestParam(name = "Mese") Integer numMese)
			throws Exception {
		ArrayList<StatisticheMensili> statsMeseBelgio = new ArrayList<StatisticheMensili>();
		if (numMese < 1 || numMese > 3)
			throw new MeseNonSupportato();
		else {
			CalcolatoreStatsMensili.getMeseArray(DatiPaesi.obj3, statsMeseBelgio, numMese);
		}
		return statsMeseBelgio;
	}

	/**
	 * Risponde alla richiesta POST /diffPercentualeItalia-Germania.
	 * 
	 * @param dataInizio : è la data a partire dalla quale verranno conteggiati i
	 *                   ricoverati di Italia e Germania.
	 * @param dataFine   : è la data entro la quale verranno conteggiati i
	 *                   ricoverati di Italia e Germania.
	 * @return Restituisce ArrayList di oggetti di tipo DifferenzaPercentuale che
	 *         contiene la differenza percentuale dei ricoverati di Italia e
	 *         Germania calcolata in un range di tempo definibile dall'utente.
	 * @throws Exception : vengono lanciate delle eccezioni se l'utente inserisce un
	 *                   intervallo di tempo che non rientra in quello permesso
	 *                   (2020/03/01 - 2020/05/31), e se l'utente inserisce una data
	 *                   di fine periodo (dataFine) antecedente alla data di inizio
	 *                   periodo (dataInizio).
	 */

	@RequestMapping(value = "/diffPercentualeItalia-Germania", method = RequestMethod.POST)
	public ArrayList<DifferenzaPercentuale> getDiffPerITGER(@RequestParam(name = "dataInizio") String dataInizio,
			@RequestParam(name = "dataFine") String dataFine) throws Exception {
		ArrayList<DifferenzaPercentuale> diffPerItaliaGermania = new ArrayList<DifferenzaPercentuale>();
		if ((FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z")))
				|| (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z"))))
			throw new IntervalloDataErrato();
		else if (FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine)))
			throw new ErroreDiInput();
		CalcolatoreDiffPercentuale.getArrayDiffPercentuale(DatiPaesi.obj1, DatiPaesi.obj2, diffPerItaliaGermania,
				dataInizio, dataFine);
		return diffPerItaliaGermania;
	}

	/**
	 * Risponde alla richiesta POST /diffPercentualeItalia-Belgio.
	 * 
	 * @param dataInizio : è la data a partire dalla quale verranno conteggiati i
	 *                   ricoverati di Italia e Belgio.
	 * @param dataFine   : è la data entro la quale verranno conteggiati i
	 *                   ricoverati di Italia e Belgio.
	 * @return Restituisce ArrayList di oggetti di tipo DifferenzaPercentuale che
	 *         contiene la differenza percentuale dei ricoverati di Italia e
	 *         Germania calcolata in un range di tempo definibile dall'utente.
	 * @throws Exception : vengono lanciate delle eccezioni se l'utente inserisce un
	 *                   intervallo di tempo che non rientra in quello permesso
	 *                   (2020/03/01 - 2020/05/31), e se l'utente inserisce una data
	 *                   di fine periodo (dataFine) antecedente alla data di inizio
	 *                   periodo (dataInizio).
	 */

	@RequestMapping(value = "/diffPercentualeItalia-Belgio", method = RequestMethod.POST)
	public ArrayList<DifferenzaPercentuale> getDiffPerITBEL(@RequestParam(name = "dataInizio") String dataInizio,
			@RequestParam(name = "dataFine") String dataFine) throws Exception {
		ArrayList<DifferenzaPercentuale> diffPerItaliaBelgio = new ArrayList<DifferenzaPercentuale>();
		if ((FormatoData.parsingData(dataInizio).before(FormatoData.parsingData("2020-03-01T00:00:00Z")))
				|| (FormatoData.parsingData(dataFine).after(FormatoData.parsingData("2020-05-31T00:00:00Z"))))
			throw new IntervalloDataErrato();
		else if (FormatoData.parsingData(dataInizio).after(FormatoData.parsingData(dataFine)))
			throw new ErroreDiInput();
		CalcolatoreDiffPercentuale.getArrayDiffPercentuale(DatiPaesi.obj1, DatiPaesi.obj3, diffPerItaliaBelgio,
				dataInizio, dataFine);
		return diffPerItaliaBelgio;
	}

}
