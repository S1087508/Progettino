package covid19.analisiPaesi.gestoreErrori;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoData {
	
	private static String formato;
	
	public FormatoData() {
		formato = "yyyy-MM-dd'T'hh:mm:ss'Z'";
	}
	
	public static Date parsingData(String dataDaParsare) throws Exception {  
	    Date sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'").parse(dataDaParsare);
	    return sdf;
	}

	
	public static String getFormato(long milliSecondi) {	
		formato = "";
		formato = "ss";	//Se il tempo in millisecondi è minore di 1000 allora si tratta di secondi
		formato = "mm";	//Se il tempo in millisecondi è minore di 60000 allora si tratta di minuti
		if(milliSecondi>=3600000) formato = "hh";	//Se il tempo in millisecondi è minore di 3600000 allora si tratta di ore
		if(milliSecondi>=86400000) formato = "dd";	//Se il tempo in millisecondi è minore di 86400000 allora si tratta di giorni
		if(milliSecondi>=Long.parseLong("2629800000")) formato = "M";	//Se il tempo in millisecondi è minore di 2629800000 allora si tratta di mesi
		if(milliSecondi>=Long.parseLong("31557600000")) formato = "Y";	//Se il tempo in millisecondi è minore di 7884008640 allora si tratta di 3 mesi
	return formato;
}
	
	public static String toString(long milliSecondi) {
		return (int)(milliSecondi/Long.parseLong("2629800000"))+"MM "+(int)((milliSecondi%Long.parseLong("2629800000"))/86400000)+"dd "+(int)(00)+"hh "+(int)(00)+"mm "+(int)(00)+"ss";
	}
	public static void setFormato(String formato) {
	FormatoData.formato = formato;
	}

}
