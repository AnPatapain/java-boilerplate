package examenExemple.myWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControllerGestionDisque implements ActionListener{
	public static String STOCKER = "stocker";
	public static String CHARGER = "charger";
	
	private Personnes personnes;
	private View view;
	
	public ControllerGestionDisque(Personnes personnes, View view) {
		this.personnes = personnes;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals(STOCKER)) {
			GestionDisque.sauvergarderPersonnes(personnes);
			view.popUpMessage("personnes vector sauvergarde. Refresh your eclipse file structure to see");
		}
		else if(arg0.getActionCommand().equals(CHARGER)) {
			
		}
	}
	
}
