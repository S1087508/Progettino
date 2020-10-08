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

import covid19.analisiPaesi.modello.Dati;
import covid19.analisiPaesi.modello.MetaDati;

import java.text.ParseException;
import java.util.ArrayList;



public class DatiPaesi 
{
	private static ArrayList<Dati>  dati = new ArrayList<Dati>();
	private static ArrayList<MetaDati> metadati = new ArrayList<MetaDati>();
	
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
		JSONArray obj1;
		try {
			Object oggetto1 = JSONValue.parseWithException(is);
			obj1 = (JSONArray)oggetto1;
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
		JSONArray obj2;
		try {
			Object oggetto2 = JSONValue.parseWithException(gs);
			obj2 = (JSONArray)oggetto2;
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
		
		URL BelgioURL = new URL("https://api.covid19api.com/total/country/belgium/status/confirmed?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z");
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
		JSONArray obj3;
		try {
			Object oggetto3 = JSONValue.parseWithException(bs);
			obj3 = (JSONArray)oggetto3;
			System.out.println("qualcosa");
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		lettore3.close();
		input3.close();
		fileBelgio.close();
		}
	
	public static ArrayList<Dati> getArrayDati() {
		return dati;
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


}
