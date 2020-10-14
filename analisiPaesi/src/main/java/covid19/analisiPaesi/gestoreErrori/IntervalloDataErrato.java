package covid19.analisiPaesi.gestoreErrori;

public class IntervalloDataErrato extends GestioneRichieste {

	public IntervalloDataErrato() {
		super();
		System.out.println("Intervallo di tempo non supportato: inserire intervalli di tempo compresi fra il 2020-03-01 e il 2020-05-31.");
	}
}
