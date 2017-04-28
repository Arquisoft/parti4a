package dashboard.listener;

/**
 * Some data for updating website.
 */
public class State {
	/** Some data. */
	private String textPositivo;
	private int numberPositivo;
	private String textNegativo;
	private int numberNegativo;

	public State(String textPositivo, int numberPositivo, String textNegativo, int numberNegativo) {
		this.textPositivo = textPositivo;
		this.numberPositivo = numberPositivo;
		this.textNegativo = textNegativo;
		this.numberNegativo= numberNegativo;
	}

	public String getTextPositivo() {
		return textPositivo;
	}

	public void setTextPositivo(String textPositivo) {
		this.textPositivo = textPositivo;
	}

	public int getNumberPositivo() {
		return numberPositivo;
	}

	public void setNumberPositivo(int numberPositivo) {
		this.numberPositivo = numberPositivo;
	}

	public String getTextNegativo() {
		return textNegativo;
	}

	public void setTextNegativo(String textNegativo) {
		this.textNegativo = textNegativo;
	}

	public int getNumberNegativo() {
		return numberNegativo;
	}

	public void setNumberNegativo(int numberNegativo) {
		this.numberNegativo = numberNegativo;
	}

	
}
	