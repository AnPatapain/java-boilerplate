package cms.cmFichiers;

public class ExempleFichiersMain {

	public static void main(String[] args) {

		// FileReader
		TestFileReader t = new TestFileReader("c:/tmp/source.txt");
		t.lecture();

	}

}
