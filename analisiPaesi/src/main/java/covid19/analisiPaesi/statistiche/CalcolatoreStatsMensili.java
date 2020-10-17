package covid19.analisiPaesi.statistiche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.StatisticheMensili;

/**
 * Classe che contiene i metodi necessari per calcolare media, mediana e
 * varianza dei ricoverati nei 3 mesi supportati.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class CalcolatoreStatsMensili {

	/**
	 * Riempie un ArrayList di oggetti di tipo StatisticheMensili che contiene
	 * media, mediana e varianza dei ricoverati calcolate in un mese scelto
	 * dall'utente.
	 * 
	 * @param j                : JSONArray del paese di cui si vogliono conoscere le
	 *                         statistiche mensili.
	 * @param listaStatistiche : ArraList di oggetti di tipo StatisticheMensili in
	 *                         cui vengono caricati i valori delle statistiche.
	 * @param numMese          : numero del mese scelto dall'utente.
	 * @throws Exception
	 */
	public static void getMeseArray(JSONArray j, ArrayList<StatisticheMensili> listaStatistiche, Integer numMese)
			throws Exception {

		listaStatistiche.clear();
		StatisticheMensili stats = new StatisticheMensili();
		stats.setMediaMese(mediaMese(j, numMese));
		stats.setVarianzaMese(varianzaMese(j, numMese));
		stats.setMedianaMese(medianaMese(j, numMese));
		listaStatistiche.add(stats);
	}

	/**
	 * Calcola la media dei ricoverati in un mese di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la media
	 *                mensile dei ricoverati.
	 * @param numMese : numero del mese scelto dall'utente.
	 * @return media dei ricoverati in un mese di un determinato paese.
	 * @throws Exception : il numero del mese scelto dall'utente deve essere
	 *                   compreso tra 1 e 3 e la lunghezza del mese scelto è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static float mediaMese(JSONArray j, Integer numMese) throws Exception {
		long ricoverati = 0;
		ArrayList<Dati> listaRicoverati = new ArrayList<Dati>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);

			if (numMese == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numMese == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-30T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-30T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numMese == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

		}
		return ricoverati / (listaRicoverati.size());
	}

	/**
	 * Calcola la varianza dei ricoverati in un mese di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la varianza
	 *                mensile dei ricoverati.
	 * @param numMese : numero del mese scelto dall'utente.
	 * @return media dei ricoverati in un mese di un determinato paese.
	 * @throws Exception : il numero del mese scelto dall'utente deve essere
	 *                   compreso tra 1 e 3 e la lunghezza del mese scelto è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static float varianzaMese(JSONArray j, Integer numMese) throws Exception {
		ArrayList<Long> listaRicoverati = new ArrayList<Long>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);
			if (numMese == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
			if (numMese == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-30T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-30T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numMese == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
		}
		return CalcolatoreStatsSettimanali.varianza(listaRicoverati, mediaMese(j, numMese));
	}

	/**
	 * Calcola la mediana dei ricoverati.
	 * 
	 * @param arrayLong : ArrayList di oggetti di tipo Long (il numero di
	 *                  ricoverati).
	 * @return la mediana.
	 */
	public static Long mediana(ArrayList<Long> arrayLong) {
		arrayLong.sort(null);
		Collections.reverse(arrayLong);
		long f = arrayLong.size();
		long mediana;
		if (f % 2 != 0)
			return mediana = arrayLong.get((int) (f / 2));
		else
			return mediana = (long) ((arrayLong.get((int) (f - 1) / 2) + arrayLong.get((int) f / 2)) / 2.0);
	}

	/**
	 * Calcola la mediana dei ricoverati in un mese di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la mediana
	 *                mensile dei ricoverati.
	 * @param numMese : numero del mese scelto dall'utente.
	 * @return mediana dei ricoverati in un mese di un determinato paese.
	 * @throws Exception : il numero del mese scelto dall'utente deve essere
	 *                   compreso tra 1 e 3 e la lunghezza del mese scelto è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static long medianaMese(JSONArray j, Integer numMese) throws Exception {
		ArrayList<Long> listaRicoverati = new ArrayList<Long>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);
			if (numMese == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
			if (numMese == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-30T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-30T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numMese == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
		}
		return mediana(listaRicoverati);
	}
}
