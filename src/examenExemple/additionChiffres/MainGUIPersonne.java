package examenExemple.additionChiffres;

import java.awt.event.ActionListener;

public class MainGUIPersonne {
	

	static GUIPersonne vue;
	
	private static Runnable tache = new Runnable() {
		public void run() {
			MainGUIPersonne.vue.createAndShowGUI();
		}
	};

	public static void main(String[] args) {
		Personnes p = new Personnes();
		MainGUIPersonne.vue = new GUIPersonne();
		ActionListener a = new Controler(p, MainGUIPersonne.vue);
		MainGUIPersonne.vue.lierListener(a);
		javax.swing.SwingUtilities.invokeLater(tache);
	}
}