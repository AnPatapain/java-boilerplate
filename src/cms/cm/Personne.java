package cms.cm;

import java.util.Calendar;

public class Personne {
	
	private String nom; 
	private Calendar dateDeNaissance;
	
	public Personne(String n, Calendar ddn) {
		this.nom = n;
		this.dateDeNaissance = ddn;
	}
	
	public Personne(String n) {
		this.nom = n;
		this.dateDeNaissance = Calendar.getInstance();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getAnneeNaissance() {
		return Integer.toString(this.dateDeNaissance.get(Calendar.YEAR));
	}
	
	public String getMoisNaissance() {
		return Integer.toString(this.dateDeNaissance.get(Calendar.MONTH));
	}

}
