package covid19.analisiPaesi.model;

/**
 * Classe che contiene oggetti rappresentanti i metadati, ovvero: sourceFields,
 * alias e tipo del dato.
 * 
 * @author Rumeysa Nur Gulesin
 *
 */
public class MetaDati {
	
	public String alias;
	public String sourceField;
	public String type;

	public MetaDati(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
