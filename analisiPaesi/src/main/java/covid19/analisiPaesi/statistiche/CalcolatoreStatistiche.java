package covid19.analisiPaesi.statistiche;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.Statistiche;

public class CalcolatoreStatistiche {

    public static float mediaSettimana(JSONArray j,String dataInizio,String dataFine) throws Exception {
  	  float ricoverati=0;
  	  ArrayList<Dati> listaRicoverati = new ArrayList<Dati>();
  	  for(int i = 0; i < j.size(); i++) {
  		  
  		  Dati datino= new Dati();
  		  JSONObject o;
  		  o=(JSONObject)j.get(i);
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData(dataInizio))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData(dataInizio))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData(dataFine)))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData(dataFine)))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  	  }
  	  return ricoverati/(listaRicoverati.size());
  	  
    }
}
