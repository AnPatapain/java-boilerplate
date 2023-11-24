package cms.cmFichiers;

import java.io.*;

public class TestFileReader {
	protected String source;

	

	/**
	 * Utilisation d'un BufferedReader pour lire un fichier (FileReader)
	 */
	public TestFileReader(String source) {
		this.source = source;
	}
	
	public String lecture() {
		try {
			char c ;
			String resultat = "";
			FileReader fichier = new FileReader(source);
			while ((c = (char)fichier.read()) != (char)-1) { // a tester avec et sans le (char) devant -1 pour voir les bugs
				System.out.print(c);
				resultat +=c;
			}
			fichier.close();
			return resultat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String lectureAvecTableau() {
		try {
			char[] c = new char[11];
			String resultat = "";
			FileReader fichier = new FileReader(source);
			fichier.read(c);
			System.out.print(c);
			resultat = String.copyValueOf(c);
			fichier.close();
			return resultat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}