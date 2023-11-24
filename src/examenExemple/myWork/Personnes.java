package examenExemple.myWork;

import java.util.Vector;

public class Personnes {
	private Vector<Personne> personnes;
	public Personnes() {
		personnes = new Vector<Personne>();
	}
	public Vector<Personne> getPersonnes() {
		return personnes;
	}
	public void addPersonne(Personne personne) {
		personnes.add(personne);
	}
}
