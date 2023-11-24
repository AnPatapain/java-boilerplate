package cms.cm7.boutonInc;

public class Modele {
	
	/**
	 * Modèle : stocke un entier (nbAppuis) et permet de l'incrémenter
	 */
	
	private int nbAppuis;
	
	public void incrementeNbAppuis() {
		this.nbAppuis++;
	}
	
	public int getNbAppuis() {
		return this.nbAppuis;
	}

}
