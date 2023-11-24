package cms.cmFichiers;

public class MainFileWriter {

	public static void main(String[] args) throws Exception {
		TestFileWriter f = new TestFileWriter("c:/tmp/sortie1.txt");
		f.traitement();
	}

}
