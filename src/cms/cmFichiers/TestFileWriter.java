package cms.cmFichiers;

import java.io.FileWriter;
import java.util.Date;

public class TestFileWriter {
	protected String fichierDestination;

	public TestFileWriter(String destination) {
		this.fichierDestination = destination;
	}
	

	public void traitement() throws Exception{//
		try {
			//String ligne ;
			int nombre = 123;
			FileWriter fichier = new FileWriter(this.fichierDestination);
			fichier.write("Bonjour tout le monde\n");
			fichier.write("Nous sommes le "+ new Date()+"\n");
			fichier.write("Le nombre magique est " + nombre+"\n");
			fichier.write("Est ce que ça va ?\n");
			fichier.close();
		} catch (Exception e) {
			e.printStackTrace(); // Discuter ici le soucis du catch qui va empêcher le test de faire une erreur
			throw(e);
		}

	}
}
