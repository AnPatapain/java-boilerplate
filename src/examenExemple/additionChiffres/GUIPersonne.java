package examenExemple.additionChiffres;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cms.cmGUI.ButtonDemo;

public class GUIPersonne {
	
	private JFrame frame;
	private JButton ajouter;
	private JButton afficher;
	private JLabel labId;
	private JLabel labNom;
	private JLabel labJour;
	private JLabel labMois;
	private JLabel labAnnee;
	public JTextField id;
	public JTextField nom;
	public JTextField jour;
	public JTextField mois;
	public JTextField annee;
	public JLabel messageErreur;
	public JLabel labPwd;
	public JTextField pwd;
		
	public GUIPersonne() {
		this.frame = new JFrame("Personne");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane(); 
		contentPane.setLayout(new GridLayout(8, 2));
		this.id = new JTextField(3);
		this.nom = new JTextField(20);
		this.jour = new JTextField(20);
		this.mois = new JTextField(20);
		this.annee = new JTextField(20);
		this.labId = new JLabel("Id");
		this.labNom = new JLabel("Nom");
		this.labJour = new JLabel("Jour");
		this.labMois = new JLabel("Mois");
		this.labAnnee = new JLabel("Annee");
		this.afficher = new JButton("Afficher");
		this.ajouter = new JButton("Ajouter");
		this.labPwd = new JLabel("Mot de passe");
		this.pwd = new JTextField(20);
		this.messageErreur = new JLabel("<message>");
		this.frame.add(this.labId);
		this.frame.add(this.id);
		this.frame.add(this.labNom);
		this.frame.add(this.nom);
		this.frame.add(this.labJour);
		this.frame.add(this.jour);
		this.frame.add(this.labMois);
		this.frame.add(this.mois);
		this.frame.add(this.labAnnee);
		this.frame.add(this.annee);
		this.frame.add(this.afficher);
		this.frame.add(this.ajouter);	
		this.frame.add(this.labPwd);
		this.frame.add(this.pwd);
		this.frame.add(this.messageErreur);
	}
	
	public void createAndShowGUI() {
		frame.pack();
		frame.setVisible(true);
	}
	
	public void lierListener(ActionListener a) {
		this.ajouter.addActionListener(a);
		this.afficher.addActionListener(a);
		this.ajouter.setActionCommand("ajouter");
		this.afficher.setActionCommand("afficher");
	}

}
