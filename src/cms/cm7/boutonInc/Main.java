package cms.cm7.boutonInc;

public class Main {
	
	private static Vue vue;

	private static Runnable tache = new Runnable() {
		public void run() {
			Main.vue.initialiserVue();
		}
	};
	
	public static void main(String[] args) {
		Modele modele = new Modele();
		Controleur controleur = new Controleur(modele);
		Main.vue = new Vue(controleur, modele);
		controleur.enregistreVue(Main.vue);
		javax.swing.SwingUtilities.invokeLater(tache);
	}

}
