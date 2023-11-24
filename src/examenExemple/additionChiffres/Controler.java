package examenExemple.additionChiffres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener{
	
	private GUIPersonne vue;
	private Personnes p;
	
	public Controler(Personnes p, GUIPersonne v) {
		this.p = p;
		this.vue = v;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("afficher")) {
			try {
			Personne temp = this.p.p.elementAt(Integer.parseInt(this.vue.id.getText()));
				this.vue.nom.setText(temp.getNom());
				this.vue.jour.setText(Integer.toString(temp.getJour()));
				this.vue.mois.setText(Integer.toString(temp.getMonth()));
				this.vue.annee.setText(Integer.toString(temp.getAnnee()));
			}catch(Exception ex) {
				this.vue.messageErreur.setText("Erreur");
				this.vue.nom.setText("erreur");
				this.vue.jour.setText("erreur");
				this.vue.mois.setText("erreur");
				this.vue.annee.setText("erreur");
				ex.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("ajouter")) {
			int id = Personne.getNextId();
			Personne temp = new Personne(this.vue.nom.getText(), Integer.parseInt(this.vue.annee.getText()), Integer.parseInt(this.vue.mois.getText()), Integer.parseInt(this.vue.jour.getText()));
			this.p.p.add(temp);
			this.vue.messageErreur.setText("Personne crée, id = "+id);
		}
		
	}

}
