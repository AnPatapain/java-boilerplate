package cms.cmFichiers;

public class MainExample {
	private static String source = "c:/tmp/sortie1.txt";
//	private static String source = "c:/tmp/source-utf8.txt";

	
	public static void main(String[] args) {
		TestFileReader t = new TestFileReader(source); // Tester source.txt, source-utf8.txt, source-utf16-LE.txt
		TestFileInputStream fis = new TestFileInputStream(source);
		System.out.println("FileReader");
		t.lecture();
		System.out.println();
		System.out.println("FileInputStream");
		fis.lecture();
		System.out.println();
		System.out.println("FileReader avec un tableau");
		t.lectureAvecTableau();
	}

}
