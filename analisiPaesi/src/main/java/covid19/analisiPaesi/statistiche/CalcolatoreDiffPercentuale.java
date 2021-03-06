package covid19.analisiPaesi.statistiche;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.DifferenzaPercentuale;
import covid19.analisiPaesi.model.StatisticheMensili;

/**
 * Classe che contiene i metodi necessari per il calcolo della differenza
 * percentuale dei ricoverati fra due paesi.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class CalcolatoreDiffPercentuale {
	/**
	 * Riempie un ArrayList di oggetti di tipo DifferenzaPercentuale.
	 * 
	 * @param j1               : JSONArray del primo paese (Italia).
	 * @param j2               : JSONArray del secondo paese (Germania o Belgio).
	 * @param listaPercentuale : ArrayList di oggetti di tipo DifferenzaPercentuale
	 *                         che verrà riempito.
	 * @param dataInizio       : data a partire dalla quale verrano prelevati i
	 *                         dati.
	 * @param dataFine         : data entro la quale verranno prelevati i dati.
	 * @throws Exception
	 */
	public static void getArrayDiffPercentuale(JSONArray j1, JSONArray j2,
			ArrayList<DifferenzaPercentuale> listaPercentuale, String dataInizio, String dataFine) throws Exception {
		listaPercentuale.clear();
		DifferenzaPercentuale stat = new DifferenzaPercentuale();
		stat.setDiffPercentuale(diffPercentualePaesi(j1, j2, dataInizio, dataFine));
		listaPercentuale.add(stat);
	}

	/**
	 * Calcola la differenza percentuale.
	 * 
	 * @param ricoverati1 : numero di ricoverati del primo paese.
	 * @param ricoverati2 : numero di ricoverati del secondo paese.
	 * @return differenza percentuale.
	 */
	public static float diffPercentuale(long ricoverati1, long ricoverati2) {
		float media = (ricoverati1 + ricoverati2) / 2;
		float diffPercentuale = ((ricoverati1 - ricoverati2) / media) * 100;
		return diffPercentuale;
	}

	/**
	 * Calcola la differenza percentuale di ricoverati tra due paesi servendosi del
	 * metodo "diffPercentuale".
	 * 
	 * @param j1         : JSONArray del primo paese.
	 * @param j2         : JSONArray del secondo paese.
	 * @param dataInizio : data a partire dalla quale verranno prelevati i dati.
	 * @param dataFine   : data entro la quale verranno prelevati i dati.
	 * @return differenza percentuale tra due paesi.
	 * @throws Exception
	 */
	public static float diffPercentualePaesi(JSONArray j1, JSONArray j2, String dataInizio, String dataFine)
			throws Exception {
		long ricoverati1 = 0;
		long ricoverati2 = 0;
		ArrayList<Long> listaRicoverati1 = new ArrayList<Long>();
		ArrayList<Long> listaRicoverati2 = new ArrayList<Long>();
		for (int i = 0; i < j1.size(); i++) {
			Dati datino1 = new Dati();
			JSONObject o1;
			o1 = (JSONObject) j1.get(i);
			if (((FormatoData.parsingData((String) o1.get("Date"))).after(FormatoData.parsingData(dataInizio))
					|| (FormatoData.parsingData((String) o1.get("Date"))).equals(FormatoData.parsingData(dataInizio)))
					&& ((FormatoData.parsingData((String) o1.get("Date"))).before(FormatoData.parsingData(dataFine))
							|| (FormatoData.parsingData((String) o1.get("Date")))
									.equals(FormatoData.parsingData(dataFine)))) {
				datino1.setCasi((Long) o1.get("Cases"));
				ricoverati1 += datino1.getCasi();
				listaRicoverati1.add(datino1.getCasi());
			}
		}
		for (int k = 0; k < j2.size(); k++) {
			Dati datino2 = new Dati();
			JSONObject o2;
			o2 = (JSONObject) j2.get(k);
			if (((FormatoData.parsingData((String) o2.get("Date"))).after(FormatoData.parsingData(dataInizio))
					|| (FormatoData.parsingData((String) o2.get("Date"))).equals(FormatoData.parsingData(dataInizio)))
					&& ((FormatoData.parsingData((String) o2.get("Date"))).before(FormatoData.parsingData(dataFine))
							|| (FormatoData.parsingData((String) o2.get("Date")))
									.equals(FormatoData.parsingData(dataFine)))) {
				datino2.setCasi((Long) o2.get("Cases"));
				ricoverati2 += datino2.getCasi();
				listaRicoverati2.add(datino2.getCasi());
			}
		}
		return diffPercentuale(ricoverati1, ricoverati2);
	}

}
