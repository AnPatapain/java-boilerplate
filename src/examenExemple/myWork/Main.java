package examenExemple.myWork;

import javax.swing.SwingUtilities;

public class Main {
	private static View view;
	private static Controller controller;
	private static ControllerGestionDisque controllerGestionDisque;
	private static Personnes personnes;
	
	private static Runnable tache = new Runnable() {
		
		@Override
		public void run() {
			view.createAndShowGUI();
		}
	};
	
	public static void main(String[] args) {
		view = new View();
		personnes = new Personnes();
		controller = new Controller(personnes, view);
		controllerGestionDisque = new ControllerGestionDisque(personnes, view);
		view.lierListenner(controller, controllerGestionDisque);
		SwingUtilities.invokeLater(tache);
	}
}
