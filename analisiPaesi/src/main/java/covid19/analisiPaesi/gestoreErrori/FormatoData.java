package covid19.analisiPaesi.gestoreErrori;

/**
 * Classe che permette di gestire il formato delle date.
 * 
 * @author Rumeysa Nur Gulesin
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoData {

	private static String formato;

	/**
	 * Definisce il formato desiderato della data.
	 */

	public FormatoData() {
		formato = "yyyy-MM-dd'T'hh:mm:ss'Z'";
	}

	/**
	 * Cambia la data da una variabile di tipo String a una di tipo Date da
	 * utilizzare nei metodi.
	 * 
	 * @param dataDaParsare : variabile di tipo String che si vuole convertire in
	 *                      tipo Date.
	 * @return Data di tipo Date.
	 * @throws Exception : lancia un'eccezione se non rispetta il formato
	 *                   predefinito.
	 */

	public static Date parsingData(String dataDaParsare) throws Exception {
		Date sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'").parse(dataDaParsare);
		return sdf;
	}
}
