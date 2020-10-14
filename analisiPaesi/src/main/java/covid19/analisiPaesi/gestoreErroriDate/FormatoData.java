package covid19.analisiPaesi.gestoreErroriDate;

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
	
	public static String controllaFormato(String data) {
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'"); 
		Date test;
		
		try {
			test = formatoData.parse(data); 		
		} catch (ParseException e) {
			return "";
		}
		
		String[] parseData = data.split("-");
		//se viene scelto un periodo di tempo al di fuori di marzo, aprile e maggio 2020, questo metodo gestisce l'errore restituendo una stringa vuota o scrivendo la data nel formato corretto
		if((Integer.parseInt(parseData[2])>31)||(Integer.parseInt(parseData[1])>6)||(Integer.parseInt(parseData[1])<3)||(Integer.parseInt(parseData[2])<1)||(Integer.parseInt(parseData[1])<1)||(Integer.parseInt(parseData[0])!=2020)) return "";
		
		if((Integer.parseInt(parseData[1])<10)&&(!parseData[2].contains("0"))){  //cambia la data da 2020/3/01 in 2020/03/01
			parseData[1] = "0"+parseData[1];
		}
		if((Integer.parseInt(parseData[2])<10)&&(!parseData[2].contains("0"))){	 //cambia la data da 2020/03/1 in 2020/03/01
			parseData[2] = "0"+parseData[2];
		}
		if(test.after(new Date(System.currentTimeMillis()))) return "";
		return parseData[0]+"-"+parseData[1]+"-"+parseData[2]; 					//restituisce la stringa scritta correttamente
		
	}
}
