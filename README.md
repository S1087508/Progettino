# Progettino
L'applicazione permette all'utente di ottenere informazioni relative al numero di ricoveri per COVID-19 in Italia, Germania e Belgio dal 01/03/2020 al 31/05/2020.
L'utente può prendere visione, in formato JSON:
* Dei MetaDati, ovvero dei source fields, degli alias e del tipo dei dati.
* Dei Dati, ovvero del numero di ricoverati registrato ogni giorno in un intervallo di tempo definibile dall'utente (compreso in quello supportato dal programma).
* Di alcune statistiche, calcolate per ognuno dei tre mesi e per ognuna delle tredici settimane che compongono il periodo di tempo supportato, quali:
  * Media del numero di ricoverati.
  * Mediana del numero di ricoverati.
  * Varianza del numero di ricoverati.
  * Differenza percentuale (tra Italia e Germania e tra Italia e Belgio) del numero di ricoverati, calcolata in un periodo di tempo definibile dall'utente.

## Guida all'utilizzo
Per usufruire delle funzionalità dell'applicazione, è necessario avviarla come **SpringBootApp** per poi inviare le chiamate di tipo **POST** o **GET** servendosi della porta http://localhost:8080. Di seguito sono riportate le richieste che possono essere eseguite tramite il Client:
Tipo | Rotta | Descrizione
-----|-------|------------
 GET | /metadati | Restituisce i metadati.
 GET | /dati | Restituisce tutti i dati relativi ai tre paesi nel periodo di tempo supportato.
 POST | /datiPeriodoItalia | Restituisce tutti i dati relativi all'Italia in un periodo di tempo definibile dall'utente, inserendo data di inizio e fine periodo.
 POST | /datiPeriodoGermania | Restituisce tutti i dati relativi alla Germania in un periodo di tempo definibile dall'utente, inserendo data di inizio e fine periodo.
 POST | /datiPeriodoBelgio | Restituisce tutti i dati relativi al Belgio in un periodo di tempo definibile dall'utente, inserendo data di inizio e fine periodo.
 POST | /statSettimanaItalia | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Italia, in una settimana scelta dall'utente.
 POST | /statSettimanaGermania | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Germania, in una settimana scelta dall'utente.
 POST | /statSettimanaBelgio | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Belgio, in una settimana scelta dall'utente.
 POST | /statMeseItalia | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Italia, in un mese scelto dall'utente.
 POST | /statMeseGermania | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Germania, in un mese scelto dall'utente.
 POST | /statMeseBelgio | Restituisce i valori della media, della mediana e della varianza del numero di ricoverati in Belgio, in un mese scelto dall'utente.
 POST | /diffPercentualeItalia-Germania | Restituisce il valore della differenza percentuale del numero di ricoverati, tra Italia e Germania 
 POST | /diffPercentualeItalia-Belgio | Restituisce il valore della differenza percentuale del numero di ricoverati, tra Italia e Belgio.

Di seguito è riportata la legenda dei parametri che possono essere inseriti dall'utente nella sezione **Params** del Client:
Key | Value |
----|-------|
dataInizio | Una data di inizio periodo nel seguente formato: aaaa-MM-ggToo:mm:ssZ.
dataFine | Una data di fine periodo nel seguente formato: aaaa-MM-ggToo:mm:ssZ.
numMese | Un numero intero compreso fra 1 e 3.
numSettimana | Un numero intero compreso tra 1 e 13.

## Sviluppo
### Casi d'Uso
![CasiDUso](https://imagizer.imageshack.com/v2/991x485q50/r/923/FNsewr.jpg)
### Packages
![Packages](https://imagizer.imageshack.com/v2/991x255q90/r/922/ZchAEt.jpg)
### Diagramma delle Classi
![DiagrammaDelleClassi](https://imagizer.imageshack.com/v2/550x428q50/r/923/QCBZNt.jpg)
### Diagrammi delle Sequenze
* Chiamata **GET** __/metadati__: PaesiRestController effettua una chiamata attraverso il metodo _getMetaDati()_ che restituisce un ArrayList di MetaDati.
![metadati](https://imagizer.imageshack.com/v2/642x428q90/r/922/zIeGi1.jpg)
* Chiamata **GET** __/dati__: PaesiRestController effettua una chiamata attraverso il metodo _getDati()_ che restituisce un ArrayList di ArrayList che contiene i dati di tutti i paesi nell'intero periodo di tempo supportato dal programma.
![dati](https://imagizer.imageshack.com/v2/642x428q50/r/923/0lpl6q.jpg)
* Chiamate **POST** __/datiPeriodoItalia__, __/datiPeriodoGermania__, __/datiPeriodoBelgio__: PaesiRestController effettua una chiamata attraverso il metodo _getArrayDati()_ che restituisce un ArrayList di Dati di un determinato paese.
![datiPeriodo](https://imagizer.imageshack.com/v2/708x428q90/r/922/UInotd.jpg)
* Chiamate **POST** _/statSettimanaItalia_, _/statSettimanaGermania_, _/statSettimanaBelgio_: PaesiRestController effettua una chiamata attraverso il metodo _getSettimanaArray()_, che invocherà a sua volta i metodi _mediaSettimana()_, _medianaSettimana()_ e _varianzaSettimana()_ attraverso i setters di **mediaSettimana**, **medianaSettimana** e **varianzaSettimana**, per restituire, infine, un ArrayList che contiene il valore delle statistiche calcolate in una settimana, in un determinato paese.
![statSettimana](https://imagizer.imageshack.com/v2/991x487q90/r/923/aQj4fA.jpg)
* Chiamate **POST** _/statMeseItalia_, _/statMeseGermania_, _/statMeseBelgio_ : PaesiRestController effettua una chiamata attraverso il metodo _getMeseArray()_, che invocherà a sua volta i metodi _mediaMese()_, _medianaMese()_, _varianzaMese()_ attraverso i setters di **mediaMese**, **medianaMese** e **varianzaMese**, per restituire, infine, un ArrayList che contiene il valore delle statistiche calcolate in un mese, in un determinato paese.
![statMese](https://imagizer.imageshack.com/v2/991x487q50/r/924/miMAJl.jpg)
* Chiamate **POST** _/diffPercentualeItalia-Germania_, _/diffPercentualeItalia-Belgio_: PaesiRestController effettua una chiamata attraverso il metodo _getArrayDiffPercentuale()_, che invocherà a sua volta il metodo _diffPercentualePaesi()_ attraverso il setter di diffPercentuale, restituendo, infine, un ArrayList che contiene il valore della differenza percentuale del numero di ricoverati fra i due paesi.
![diffPer](https://imagizer.imageshack.com/v2/991x487q90/r/922/YpxHNA.jpg)
# Autore
**Rumeysa Nur Gulesin** - [GitHub](https://github.com/S1087508/Progettino)
