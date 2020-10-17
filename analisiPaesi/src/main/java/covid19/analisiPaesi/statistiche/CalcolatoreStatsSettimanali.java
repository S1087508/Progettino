package covid19.analisiPaesi.statistiche;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.StatisticheMensili;
import covid19.analisiPaesi.model.StatisticheSettimanali;

/**
 * Classe che contiene i metodi necessari per calcolare media, mediana e
 * varianza dei ricoverati nelle 13 settimane supportate.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class CalcolatoreStatsSettimanali {

	/**
	 * Riempie un ArrayList di oggetti di tipo StatisticheSettimanali che contiene
	 * media, mediana e varianza dei ricoverati calcolate in una settimana scelta
	 * dall'utente.
	 * 
	 * @param j                : JSONArray del paese di cui si vogliono conoscere le
	 *                         statistiche settimanali.
	 * @param listaStatistiche : ArraList di oggetti di tipo StatisticheSettimanali
	 *                         in cui vengono caricati i valori delle statistiche.
	 * @param numSettimana     : numero della settiman scelta dall'utente.
	 * @throws Exception
	 */
	public static void getSettimanaArray(JSONArray j, ArrayList<StatisticheSettimanali> listaStatistiche,
			Integer numSettimana) throws Exception {

		listaStatistiche.clear();
		StatisticheSettimanali stats = new StatisticheSettimanali();
		stats.setMediaSettimana(mediaSettimana(j, numSettimana));
		stats.setVarianzaSettimana(varianzaSettimana(j, numSettimana));
		stats.setMedianaSettimana(medianaSettimana(j, numSettimana));
		listaStatistiche.add(stats);
	}

	/**
	 * Calcola la media dei ricoverati in una settimana di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la media
	 *                settimanale dei ricoverati.
	 * @param numMese : numero della settimana scelta dall'utente.
	 * @return media dei ricoverati in una settimana di un determinato paese.
	 * @throws Exception : il numero della settimana scelto dall'utente deve essere
	 *                   compreso tra 1 e 13 e la lunghezza della settimana scelta è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static float mediaSettimana(JSONArray j, Integer numSettimana) throws Exception {
		float ricoverati = 0;
		ArrayList<Dati> listaRicoverati = new ArrayList<Dati>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);

			if (numSettimana == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-07T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-07T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-08T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-08T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-14T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-14T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}
			if (numSettimana == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-15T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-15T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-21T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-21T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 4) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-22T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-22T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-28T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-28T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 5) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-29T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-29T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-04T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-04T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 6) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-05T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-05T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-11T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-11T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 7) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-12T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-12T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-18T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-18T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 8) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-19T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-19T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-25T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-25T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 9) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-26T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-26T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-02T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-02T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 10) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-03T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-03T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-09T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-09T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 11) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-10T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-10T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-16T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-16T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 12) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-17T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-17T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-23T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-23T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					ricoverati += datino.getCasi();
					listaRicoverati.add(datino);
				}
			}

			if (numSettimana == 13) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-24T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-24T00:00:00Z"))))
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
	 * Calcola la varianza.
	 * 
	 * @param arrayLong : ArrayList di oggetti di tipo Long dei quali si vuole
	 *                  calcolare la varianza.
	 * @param media     : media dei ricoverati.
	 * @return varianza.
	 */
	public static float varianza(ArrayList<Long> arrayLong, float media) {
		float sommaScartiQuad = 0;
		for (Long i : arrayLong) {
			sommaScartiQuad += (i - media) * (i - media);
		}
		float varianza = sommaScartiQuad / (arrayLong.size() - 1);
		return varianza;
	}

	/**
	 * Calcola la varianza dei ricoverati in una settimana di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la varianza
	 *                settimanale dei ricoverati.
	 * @param numMese : numero della settimana scelto dall'utente.
	 * @return varianza dei ricoverati in una settimana di un determinato paese.
	 * @throws Exception : il numero della settimana scelto dall'utente deve essere
	 *                   compreso tra 1 e 13 e la lunghezza del mese scelto è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static float varianzaSettimana(JSONArray j, Integer numSettimana) throws Exception {
		ArrayList<Long> listaRicoverati = new ArrayList<Long>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);
			if (numSettimana == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-07T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-07T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
			if (numSettimana == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-08T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-08T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-14T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-14T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-15T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-15T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-21T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-21T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 4) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-22T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-22T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-28T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-28T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 5) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-29T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-29T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-04T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-04T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 6) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-05T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-05T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-11T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-11T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 7) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-12T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-12T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-18T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-18T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 8) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-19T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-19T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-25T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-25T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 9) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-26T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-26T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-02T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-02T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 10) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-03T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-03T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-09T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-09T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 11) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-10T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-10T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-16T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-16T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 12) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-17T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-17T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-23T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-23T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 13) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-24T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-24T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
		}
		return varianza(listaRicoverati, mediaSettimana(j, numSettimana));
	}

	/**
	 * Calcola la mediana dei ricoverati in una settimana di un paese.
	 * 
	 * @param j       : JSONArray del paese di cui si vuole calcolare la mediana
	 *                settimanale dei ricoverati.
	 * @param numMese : numero della settimana scelto dall'utente.
	 * @return mediana dei ricoverati in una settimana di un determinato paese.
	 * @throws Exception : il numero della settimana scelto dall'utente deve essere
	 *                   compreso tra 1 e 13 e la lunghezza della settimana scelta è
	 *                   definita dalle condizioni degli if all'interno del metodo.
	 */
	public static long medianaSettimana(JSONArray j, Integer numSettimana) throws Exception {
		ArrayList<Long> listaRicoverati = new ArrayList<Long>();
		for (int i = 0; i < j.size(); i++) {
			Dati datino = new Dati();
			JSONObject o;
			o = (JSONObject) j.get(i);
			if (numSettimana == 1) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-07T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-07T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
			if (numSettimana == 2) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-08T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-08T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-14T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-14T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 3) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-15T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-15T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-21T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-21T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 4) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-22T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-22T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-03-28T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-03-28T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 5) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-03-29T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-03-29T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-04T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-04T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 6) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-05T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-05T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-11T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-11T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 7) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-12T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-12T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-18T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-18T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 8) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-19T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-19T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-04-25T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-04-25T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 9) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-04-26T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-04-26T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-02T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-02T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 10) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-03T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-03T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-09T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-09T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 11) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-10T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-10T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-16T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-16T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 12) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-17T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-17T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-23T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-23T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}

			if (numSettimana == 13) {
				if (((FormatoData.parsingData((String) o.get("Date")))
						.after(FormatoData.parsingData("2020-05-24T00:00:00Z"))
						|| ((FormatoData.parsingData((String) o.get("Date")))
								.equals(FormatoData.parsingData("2020-05-24T00:00:00Z"))))
						&& ((FormatoData.parsingData((String) o.get("Date"))
								.before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
								|| ((FormatoData.parsingData((String) o.get("Date")))
										.equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
					datino.setCasi((Long) o.get("Cases"));
					listaRicoverati.add(datino.getCasi());
				}
			}
		}
		return CalcolatoreStatsMensili.mediana(listaRicoverati);
	}
}
