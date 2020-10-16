package covid19.analisiPaesi.statistiche;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import covid19.analisiPaesi.gestoreErrori.FormatoData;
import covid19.analisiPaesi.model.Dati;
import covid19.analisiPaesi.model.StatisticheMensili;
import covid19.analisiPaesi.model.StatisticheSettimanali;

public class CalcolatoreStatsSettimanali {
	
	public static void getSettimanaArray(JSONArray j, ArrayList<StatisticheSettimanali> listaStatistiche, Integer numMese) throws Exception {
		
		listaStatistiche.clear();
		StatisticheSettimanali stats= new StatisticheSettimanali();
		stats.setMediaSettimana(mediaSettimana(j, numMese));
		stats.setVarianzaSettimana(varianzaSettimana(j, numMese));
		listaStatistiche.add(stats);
	}
	
    public static float mediaSettimana(JSONArray j,Integer numSettimana) throws Exception {
  	  float ricoverati=0;
  	  ArrayList<Dati> listaRicoverati = new ArrayList<Dati>();
  	  for(int i = 0; i < j.size(); i++) {
  		  Dati datino= new Dati();
  		  JSONObject o;
  		  o=(JSONObject)j.get(i);
  		 
  		  if(numSettimana == 1) {
  			  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-07T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-07T00:00:00Z"))))) {
  				  datino.setCasi((Long) o.get("Cases"));
  				  ricoverati += datino.getCasi();
  				  listaRicoverati.add(datino);
  				  }
  			  }
  		  
  		  if(numSettimana == 2) {
  			  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-08T00:00:00Z"))
  					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-08T00:00:00Z"))))
  					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-14T00:00:00Z")))
  					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-14T00:00:00Z"))))) {
  				  datino.setCasi((Long) o.get("Cases"));
    			  ricoverati += datino.getCasi();
    			  listaRicoverati.add(datino);
    			  }
    		  }
  		  if(numSettimana == 3) {
  			  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-15T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-15T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-21T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-21T00:00:00Z"))))) {
  				  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 4) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-22T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-22T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-28T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-28T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 5) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-29T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-29T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-04T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-04T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 6) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-05T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-05T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-11T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-11T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 7) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-12T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-12T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-18T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-18T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 8) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-19T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-19T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-25T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-25T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 9) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-26T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-26T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-02T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-02T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 10) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-03T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-03T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-09T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-09T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 11) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-10T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-10T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-16T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-16T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 12) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-17T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-17T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-23T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-23T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		if(numSettimana == 13) {
  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-24T00:00:00Z"))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-24T00:00:00Z"))))
					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-31T00:00:00Z")))))
			{
  			  datino.setCasi((Long) o.get("Cases"));
  			  ricoverati += datino.getCasi();
  			  listaRicoverati.add(datino);
			}
  		  }
  		
  		  
  	  }
  	  return ricoverati/(listaRicoverati.size());
    }
    
    public static float varianza(ArrayList<Long> arrayLong, float media) {
		float sommaScartiQuad = 0;
		for(Long i: arrayLong) {
			sommaScartiQuad += (i-media)*(i-media);
		}
		float varianza = sommaScartiQuad / (arrayLong.size()-1);
		return varianza;
    }
    
    public static float varianzaSettimana(JSONArray j, Integer numSettimana) throws Exception {
		  ArrayList<Long> listaRicoverati = new ArrayList<Long>();
		  for(int i = 0; i < j.size(); i++) {
			  Dati datino= new Dati();
	  		  JSONObject o;
	  		  o=(JSONObject)j.get(i);
	  		  if(numSettimana == 1) {
	  	  		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-01T00:00:00Z"))
	  						||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-01T00:00:00Z"))))
	  						&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-07T00:00:00Z")))
	  						||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-07T00:00:00Z"))))) {
	    			  datino.setCasi((Long) o.get("Cases"));
	    			  listaRicoverati.add(datino.getCasi());
	    		  }
	  		}
	    		if(numSettimana == 2) {
	      		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-08T00:00:00Z"))
	    					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-08T00:00:00Z"))))
	    					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-14T00:00:00Z")))
	    					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-14T00:00:00Z"))))) {
	    			  datino.setCasi((Long) o.get("Cases"));
	    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	  		  
	      		if(numSettimana == 3) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-15T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-15T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-21T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-21T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 4) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-22T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-22T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-03-28T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-28T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 5) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-03-29T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-03-29T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-04T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-04T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 6) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-05T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-05T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-11T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-11T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 7) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-12T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-12T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-18T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-18T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 8) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-19T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-19T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-04-25T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-25T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 9) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-04-26T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-04-26T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-02T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-02T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 10) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-03T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-03T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-09T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-09T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 11) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-10T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-10T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-16T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-16T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 12) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-17T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-17T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-23T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-23T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
	      		
	      		if(numSettimana == 13) {
	        		  if(((FormatoData.parsingData((String)o.get("Date"))).after(FormatoData.parsingData("2020-05-24T00:00:00Z"))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-24T00:00:00Z"))))
	      					&&((FormatoData.parsingData((String)o.get("Date")).before(FormatoData.parsingData("2020-05-31T00:00:00Z")))
	      					||((FormatoData.parsingData((String)o.get("Date"))).equals(FormatoData.parsingData("2020-05-31T00:00:00Z"))))) {
		    			  datino.setCasi((Long) o.get("Cases"));
		    			  listaRicoverati.add(datino.getCasi());
		    			  }
	  	  		}
		  }
		  return varianza(listaRicoverati, mediaSettimana(j, numSettimana));
	  }
}
