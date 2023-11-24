package cms.cm7.boutonInc;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Vue {
	
	private String prefixe = "Appuis : ";
	private JButton bouton;
	private JLabel legende;
	private Modele modele;
	
	public Vue(Controleur _controleur, Modele _modele) {
		this.modele = _modele;
		this.bouton = new JButton();
		this.bouton.setText("Compteur");
		this.bouton.addActionListener(_controleur);
		this.legende= new JLabel();
		raffraichitVue();
	}
	
	public void initialiserVue() {
//		JFrame.setDefaultLookAndFeelDecorated(true); // Pour changer le look and feel
		JFrame frame = new JFrame("Démo MVC un Bouton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Gérer le Layout
		Container contentPane = frame.getContentPane(); 
		contentPane.setLayout(new FlowLayout());
		//
		frame.add(this.bouton);
		frame.add(this.legende);
		frame.pack();
		frame.setVisible(true); // Enregistrement auprès du gestionnaire d'évènements
	}
	
	public void raffraichitVue() {
		this.legende.setText(prefixe + this.modele.getNbAppuis());
	}

}
