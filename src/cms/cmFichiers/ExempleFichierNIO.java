package cms.cmFichiers;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExempleFichierNIO {
	
	public static void main(String[] args) throws Exception {
		List<String> lignes =  Files.readAllLines(FileSystems.getDefault().getPath("c:/tmp/test.txt"), StandardCharsets.UTF_8);  
		for (String ligne : lignes)
			System.out.println(ligne);


		Path pathSource = Paths.get("c:/tmp/test.txt");
		Path pathCible = Paths.get("c:/tmp/cible.txt");
		lignes = Files.readAllLines(pathSource, Charset.defaultCharset());
		Files.write(pathCible, lignes, Charset.defaultCharset());

		// En binaire
		Path file = FileSystems.getDefault().getPath("c:/tmp/test.txt");
		byte[] contenu = Files.readAllBytes(file);
		
		// Avec un bufferedReader
	    Path sourcePath = Paths.get("C:/tmp/test.txt");
	    try (BufferedReader reader = Files.newBufferedReader(sourcePath,
	        StandardCharsets.UTF_8)) {
	      String line = null;
	      while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	      }
	    }

	}

}
