package cms.cm;

public class Allocataire extends Personne{
	
	public double montantAllocs;
	
	public Allocataire(String _s) {
		super(_s);
		this.montantAllocs = 0;
	}
	
	public String getNom() {
		return super.getNom()+" Allocs ="+this.montantAllocs;
	}

}
