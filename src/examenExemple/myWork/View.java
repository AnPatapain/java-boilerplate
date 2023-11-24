package examenExemple.myWork;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class View{
	public JFrame jFrame;
	private JLabel idLabel;
	private JLabel nomLabel;
	private JLabel jourLabel;
	private JLabel moisLabel;
	private JLabel anneeLabel;
	private JLabel messageLabel;
	private JLabel motDePassLabel;
	private JLabel fileLabel;
	
	public JTextField idTextField;
	public JTextField nomTextField;
	public JTextField jourTextField;
	public JTextField moisTextField;
	public JTextField anneeTextField;
	public JTextField motDePassTextField;
	private JTextField fileTextField;
	
	private JButton afficherButton;
	private JButton ajouterButton;
	private JButton sauvergarderButton;
	private JButton chargerButton;
	
	
	public View() {
		this.jFrame = new JFrame("Personne");
		
		this.idLabel = new JLabel("id");
		this.nomLabel = new JLabel("nom");
		this.jourLabel = new JLabel("jour");
		this.moisLabel = new JLabel("mois");
		this.anneeLabel = new JLabel("annee");
		this.motDePassLabel = new JLabel("Mot de Pass");
		this.fileLabel = new JLabel("Charger from: ");
		this.messageLabel = new JLabel("<message>");
		
		this.idTextField = new JTextField(20);
		this.nomTextField = new JTextField(20);
		this.jourTextField = new JTextField(20);
		this.moisTextField = new JTextField(20);
		this.anneeTextField = new JTextField(20);
		this.motDePassTextField = new JTextField(20);
		this.fileTextField = new JTextField(20);
		
		this.afficherButton = new JButton("Afficher");
		this.ajouterButton = new JButton("Ajouter");
		this.sauvergarderButton = new JButton("Sauvegarder");
		this.chargerButton = new JButton("Charger");
		
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.jFrame.getContentPane(); 
		contentPane.setLayout(new GridLayout(10, 2));
		
		this.jFrame.add(idLabel);this.jFrame.add(idTextField);
		this.jFrame.add(nomLabel);this.jFrame.add(nomTextField);
		this.jFrame.add(jourLabel);this.jFrame.add(jourTextField);
		this.jFrame.add(moisLabel);this.jFrame.add(moisTextField);
		this.jFrame.add(anneeLabel);this.jFrame.add(anneeTextField);
		this.jFrame.add(afficherButton);this.jFrame.add(ajouterButton);
		this.jFrame.add(motDePassLabel);this.jFrame.add(motDePassTextField);
		this.jFrame.add(fileLabel);this.jFrame.add(fileTextField);
		this.jFrame.add(sauvergarderButton);this.jFrame.add(chargerButton);
		this.jFrame.add(messageLabel);
	}
	
	public void createAndShowGUI() {
		this.jFrame.pack();
		this.jFrame.setVisible(true);
	}
	
	public void lierListenner(Controller controller, ControllerGestionDisque controllerGestionDisque) {
		this.afficherButton.setActionCommand("afficher");
		this.ajouterButton.setActionCommand("ajouter");
		this.afficherButton.addActionListener(controller);
		this.ajouterButton.addActionListener(controller);
		
		this.sauvergarderButton.setActionCommand(ControllerGestionDisque.STOCKER);
		this.chargerButton.setActionCommand(ControllerGestionDisque.CHARGER);
		this.sauvergarderButton.addActionListener(controllerGestionDisque);
		this.chargerButton.addActionListener(controllerGestionDisque);
	}
	
	public void setMessage(String message) {
		this.messageLabel.setText(message);
	}
	
	public void popUpMessage(String message) {
		JOptionPane.showMessageDialog(jFrame, message);
	}
}
