
package examenExemple.myWork;

import java.io.Serializable;
import java.util.Calendar;

public class Personne implements Serializable{
	private static int nbPersonnes=0;
	private int id;
	private String nom; 
	private Calendar dateDeNaissance;
	
	public Personne() {
		
	}
	
	public Personne(String n, int year, int month, int day) {
		this.nom = n;
		this.dateDeNaissance = Calendar.getInstance();
		this.dateDeNaissance.set(Calendar.YEAR, year);
		this.dateDeNaissance.set(Calendar.MONTH, month);
		this.dateDeNaissance.set(Calendar.DAY_OF_MONTH, day);
		this.id=Personne.nbPersonnes++;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getJour() {
		return this.dateDeNaissance.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMonth() {
		return this.dateDeNaissance.get(Calendar.MONTH);
	}
	
	public int getAnnee() {
		return this.dateDeNaissance.get(Calendar.YEAR);
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public static int getNextId() {
		return Personne.nbPersonnes;
	}
}
