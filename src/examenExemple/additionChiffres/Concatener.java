package examenExemple.additionChiffres;

public class Concatener {
	
	private static String valeur;
	
	public void plus(String s) {
		Concatener.valeur += s;
	}
	
	public String getValeur() {
		return Concatener.valeur;
	}
	
	public Concatener() {
		Concatener.valeur = "";
	}
	

}
