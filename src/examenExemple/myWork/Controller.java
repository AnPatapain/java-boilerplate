package examenExemple.myWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Controller implements ActionListener{
	private Personnes personneList;
	private View view;

	public Controller(Personnes personnes, View view) {
		this.personneList = personnes;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("ajouter")) {
			String nom = view.nomTextField.getText();
			int year = Integer.valueOf(view.anneeTextField.getText());
			int month = Integer.valueOf(view.moisTextField.getText());
			int day = Integer.valueOf(view.jourTextField.getText());
			String password = view.motDePassTextField.getText();
			
			Personne personne = new PersonneChiffre(nom, year, month, day, password);
			
			personneList.addPersonne(personne);
			
			view.setMessage("Personne cree, id: " + personne.getId());
		}
		else if(arg0.getActionCommand().equals("afficher")) {
			int targetId = Integer.valueOf(view.idTextField.getText());
			String password = view.motDePassTextField.getText();
			Personne targetPersonne = null;
			
			for(Personne personne : personneList.getPersonnes()) {
				if(personne.getId() == targetId) {
					targetPersonne = personne;
				}
			}
			if(targetPersonne == null) {
				view.setMessage("Personne " + targetId + " nexiste pas !!");
			}else {
				String nom = ((PersonneChiffre)targetPersonne).getNom(password);
				if(nom != null) {
					view.nomTextField.setText(nom);
				}
				view.setMessage("Personne: " + nom + " trouvee !");
			}
		}
	}
	
}
