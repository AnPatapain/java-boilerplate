package cms.cm7.boutonInc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener{
	
	private Modele modele;
	private Vue vue;
	
	public Controleur (Modele _modele) {
		this.modele = _modele;
	}

	public void enregistreVue(Vue vue) {
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.modele.incrementeNbAppuis();
		this.vue.raffraichitVue();
	}
}
