package covid19.analisiPaesi.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import covid19.analisiPaesi.gestoreErroriDate.FormatoData;
import covid19.analisiPaesi.modello.Dati;
import covid19.analisiPaesi.modello.MetaDati;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;



public class DatiPaesi 
{
	private static ArrayList<Dati>  dati = new ArrayList<Dati>();
	private static ArrayList<MetaDati> metadati = new ArrayList<MetaDati>();
	private static ArrayList<Dati> DatiItalia = new ArrayList<Dati>();
	private static ArrayList<Dati> DatiGermania = new ArrayList<Dati>();
	private static ArrayList<Dati> DatiBelgio = new ArrayList<Dati>();
	private static JSONArray obj1;

	
	public static void scaricaDatiPaesi() throws IOException
	{
		int i = 0; //variabile per l'input di lettura per fileItalia
		int g = 0; //variabile per l'input di lettura per fileGermania
		int b = 0; //variabile per l'input di lettura per fileFrancia
		
		String is = ""; //variabile per la lettura del file Italia.json
		String gs = ""; //variabile per la lettura del file Germania.json
		String bs = ""; //variabile per la lettura del file Francia.json
		
		/**
		 *  Creazione del file che contiene il numero dei ricoverati in Italia dal 01/03/2020 al 31/05/2020
		 *  e conversione in JSON
		 */
		
		File italia = new File("Italia.json");
		FileOutputStream fileItalia = new FileOutputStream(italia);
		
		URL ItaliaURL = new URL("https://api.covid19api.com/country/italy/status/recovered?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z\r\n");
		URLConnection URLConn1 = ItaliaURL.openConnection();
		InputStream input1 = URLConn1.getInputStream();
		//come unirli in un unico while???
		while((i = input1.read()) != -1)
		{
			fileItalia.write(i);
		}
	    //conversione in JSON
		FileReader lettore1 = new FileReader("Italia.json");
		int successivo1 = 0;
		is += (char)successivo1;
		
		while(successivo1 != -1) {
			successivo1 = lettore1.read();
			is += (char)successivo1;
		}
		is = is.substring(1,is.length()-1);
		final JSONArray obj1;
		try {
			Object oggetto1 = JSONValue.parseWithException(is);
			obj1 = (JSONArray)oggetto1;
			getArrayDati(obj1, DatiItalia);
			//togliere il seguente println quando avrai terminato il programma
			System.out.println("qualcosa");
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		lettore1.close();
		input1.close();
		fileItalia.close();
		
		
		/**
		 * Creazione del file che contiene il numero dei ricoverati Germania dal 01/03/2020 al 31/05/2020
		 * e conversione in JSON
		 */
		
		File germania = new File("Germania.json");
		FileOutputStream fileGermania = new FileOutputStream(germania);
		
		URL GermaniaURL = new URL("https://api.covid19api.com/country/germany/status/recovered?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z\r\n");
		URLConnection URLConn2 = GermaniaURL.openConnection();
		InputStream input2 = URLConn2.getInputStream();
		
		while((g = input2.read()) != -1)
		{
			fileGermania.write(g);
		}
		//conversione in JSON
		FileReader lettore2 = new FileReader("Germania.json");
		int successivo2 = 0;
		gs += (char)successivo2;
		
		while(successivo2 != -1) {
			successivo2 = lettore2.read();
			gs += (char)successivo2;
		}
		gs = gs.substring(1,gs.length()-1);
		final JSONArray obj2;
		try {
			Object oggetto2 = JSONValue.parseWithException(gs);
			obj2 = (JSONArray)oggetto2;
			getArrayDati(obj2, DatiGermania);
			System.out.println("qualcosa");
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		lettore2.close();
		input2.close();
		fileGermania.close();
		
		
		/**
		 * Creazione del file che contiene il numero di ricoverati Francia dal 01/03/2020 al 31/05/2020
		 * e conversione in JSON
		 */
		
		File belgio = new File("Belgio.json");
		FileOutputStream fileBelgio = new FileOutputStream(belgio);
		
		URL BelgioURL = new URL("https://api.covid19api.com/total/country/belgium/status/recovered?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z");
		URLConnection URLConn3 = BelgioURL.openConnection();
		InputStream input3 = URLConn3.getInputStream();
		
		while((b = input3.read()) != -1)
		{
			fileBelgio.write(b);
		}
		//conversione in JSON
		FileReader lettore3 = new FileReader("Belgio.json");
		int successivo3 = 0;
		bs += (char)successivo3;
		
		while(successivo3 != -1) {
			successivo3 = lettore3.read();
			bs += (char)successivo3;
		}
		bs = bs.substring(1,bs.length()-1);
		final JSONArray obj3;
		try {
			Object oggetto3 = JSONValue.parseWithException(bs);
			obj3 = (JSONArray)oggetto3;
			getArrayDati(obj3, DatiBelgio);
			System.out.println("qualcosa");
			
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		lettore3.close();
		input3.close();
		fileBelgio.close();
		}
	
	public static ArrayList<Dati> getArrayDati(JSONArray j, ArrayList<Dati> dati) {
		for(int i = 0; i < j.size(); i++) {
			JSONObject o;
			Dati dati1 = new Dati();
			o = (JSONObject) j.get(i);
			dati1.setNomePaese((String) o.get("Country"));
			dati1.setCodicePaese((String) o.get("CountryCode"));
			dati1.setProvincia((String) o.get("Province"));
			dati1.setCitta((String) o.get("City"));
			dati1.setCodiceCitta((String) o.get("CityCode"));
			dati1.setLatitudine((String) o.get("Lat"));
			dati1.setLongitudine((String) o.get("Lon"));
			dati1.setCasi((Long) o.get("Cases"));
			dati1.setStato((String) o.get("Status"));
			dati1.setDataCorrente((String) o.get("Date"));
			dati.add(dati1);
		}
		return dati;
	}
	
	public static ArrayList<ArrayList<Dati>> getDati() {
		ArrayList<ArrayList<Dati>> listaDeiPaesi = new ArrayList<ArrayList<Dati>>();
		listaDeiPaesi.add(DatiItalia);
		listaDeiPaesi.add(DatiGermania);
		listaDeiPaesi.add(DatiBelgio);
		return listaDeiPaesi;
	}
	
	public static ArrayList<MetaDati> getArrayMetaDati() {
		
		metadati.add(new MetaDati("nomePaese","Nome del paese","String"));
		metadati.add(new MetaDati("codicePaese","Codice identificativo del Paese","String"));
		metadati.add(new MetaDati("provincia","Provincia del paese","String"));
		metadati.add(new MetaDati("nomeCitta","Nome della città","String"));
		metadati.add(new MetaDati("codiceCitta","Codice della città","String"));
		metadati.add(new MetaDati("latitudine","Latitudine del paese","Double"));
		metadati.add(new MetaDati("longitudine","Longitudine del paese","Double"));
		metadati.add(new MetaDati("casi","Numero totale di casi","Integer"));
		metadati.add(new MetaDati("stato","Status dei dei casi","String"));
		metadati.add(new MetaDati("dataCorrente","Data Corrente","Date"));
		return metadati;
	}

	public static ArrayList<ArrayList<Dati>> getPeriodoItalia(String dataInizio, String dataFine) throws Exception {
	    String da = "2020-03-01";  
	    Date da1 = new SimpleDateFormat("aaaa-MM-gg").parse(da);
	    String a = "2020-05-31";
	    Date a1 = new SimpleDateFormat("aaaa-MM-gg").parse(a);
		if(FormatoData.parsingData(dataInizio).after(da1) && FormatoData.parsingData(dataFine).before(a1))
		getArrayDati(obj1, DatiItalia);
		return obj1;	
	}
	
	


}


