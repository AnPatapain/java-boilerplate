package cms.cmFichiers;

import java.io.*;

public class TestBufferedReader {
	protected String source;

	

	/**
	 * Utilisation d'un BufferedReader pour lire un fichier (FileReader)
	 */
	public TestBufferedReader(String source) {
		this.source = source;
	}
	
	public String lecture() {
		try {
			String ligne ;
			String resultat = "";
			BufferedReader fichier = new BufferedReader(new FileReader(source));
			while ((ligne = fichier.readLine()) != null) {
				System.out.println(ligne);
				resultat +=ligne;
			}
			fichier.close();
			return resultat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}