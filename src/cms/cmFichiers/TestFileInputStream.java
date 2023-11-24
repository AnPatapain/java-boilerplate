package cms.cmFichiers;

import java.io.FileInputStream;


public class TestFileInputStream {

	
	protected String source;

	

	public TestFileInputStream(String source) {
		this.source = source;
	}
	
	public String lecture() {
		try {
			byte c ;
			String resultat = "";
			FileInputStream fis = new FileInputStream(source);
			while ((c = (byte)fis.read()) != -1) { // voir ce qui se passe si on lit un char et non un byte
				System.out.print((char)c+"("+c+")");
				resultat +=c;
			}
			fis.close();
			return resultat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
