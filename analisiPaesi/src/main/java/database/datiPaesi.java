package database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class datiPaesi 
{
	
	public static void scaricaDati() throws IOException
	{
		int i = 0; //variabile per l'input di lettura per fileItalia
		int g = 0; //variabile per l'input di lettura per fileGermania
		int f = 0; //variabile per l'input di lettura per fileFrancia
		
		
		/**
		 *  Creazione del file che contiene i dati relativi all'Italia dal 01/03/2020 al 31/05/2020
		 */
		
		File italia = new File("Italia.json");
		FileOutputStream fileItalia = new FileOutputStream(italia);
		
		URL ItaliaURL = new URL("https://api.covid19api.com/country/italy?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z");
		URLConnection URLConn1 = ItaliaURL.openConnection();
		InputStream input1 = URLConn1.getInputStream();
		
		while((i = input1.read()) != -1)
		{
			fileItalia.write(i);
		}
		input1.close();
		fileItalia.close();
		
		
		/**
		 * Creazione del file che contiene i dati relativi alla Germania dal 01/03/2020 al 31/05/2020
		 */
		
		File germania = new File("Germania.json");
		FileOutputStream fileGermania = new FileOutputStream(germania);
		
		URL GermaniaURL = new URL("https://api.covid19api.com/country/germany?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z");
		URLConnection URLConn2 = GermaniaURL.openConnection();
		InputStream input2 = URLConn2.getInputStream();
		
		while((g = input2.read()) != -1)
		{
			fileGermania.write(g);
		}
		input2.close();
		fileGermania.close();
		
		
		/**
		 * Creazione del file che contiene dati relativi alla Francia dal 01/03/2020 al 31/05/2020
		 */
		
		File francia = new File("Francia.json");
		FileOutputStream fileFrancia = new FileOutputStream(francia);
		
		URL FranciaURL = new URL("https://api.covid19api.com/country/france?from=2020-03-01T00:00:00Z&to=2020-05-31T00:00:00Z");
		URLConnection URLConn3 = FranciaURL.openConnection();
		InputStream input3 = URLConn3.getInputStream();
		
		while((f = input3.read()) != -1)
		{
			fileFrancia.write(f);
		}
		input3.close();
		fileFrancia.close();
		
	}


}
