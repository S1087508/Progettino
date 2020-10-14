package covid19.analisiPaesi.gestoreErrori;

public class ErroreDiInput extends GestioneRichieste {
	
	public ErroreDiInput() {
		super();
		System.out.println("dataInizio deve essere antecedente a dataFine.");
	}

}
