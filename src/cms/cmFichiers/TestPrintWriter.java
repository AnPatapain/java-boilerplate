package cms.cmFichiers;

import java.io.*;
import java.util.*;
	
public class TestPrintWriter {
	protected String destination;

	public TestPrintWriter(String destination) {
		this.destination = destination;
	}
	

	public void traitement() throws Exception{//
		try {
			//String ligne ;
			int nombre = 123;
			PrintWriter fichier = new PrintWriter(new FileWriter(destination));
			fichier.println("Bonjour tout le monde");
			fichier.println("Nous sommes le "+ new Date());
			fichier.println("Le nombre magique est " + nombre);
			fichier.write("Est ce que ça va ?\n");
			fichier.close();
		} catch (Exception e) {
			e.printStackTrace(); // Discuter ici le soucis du catch qui va empêcher le test de faire une erreur
			throw(e);
		}

	}
}
