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
}
