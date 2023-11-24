package cms.cmConcurrence;

public class GrandCompteur implements Runnable{

	private int cible = 0;
	private int valeur;
	private int increment;
	public volatile boolean atteint = false;
	
	public GrandCompteur(int i, int inc) {
		this.cible = i;
		this.increment = inc;
		this.valeur = 0;
		this.atteint = false;
	}

	public void run() {
		while(!atteint){
			this.incrementerPlusieursFois(this.increment);
			System.out.println(this.getValeur());

		}
	}
	
	public void incrementerPlusieursFois(int i) {
		for(int j=0;j<i;j++) {
			this.valeur++;
		}
		if(this.cible == this.valeur) {
			this.atteint = true;
		}
	}
	
	public int getValeur() {
		return this.valeur;
	}

}
