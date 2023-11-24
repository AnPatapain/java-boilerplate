package cms.cmFichiers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExempleProbe {
 
  public static void main(String[] args) { 
    try {
      Path source = Paths.get("c:/tmp/monfichier.txt");
      testProbeContent(source);
      source = Paths.get("c:/tmp/monfichier.bin");
      testProbeContent(source);
      source = Paths.get("c:/tmp/monfichier");
      testProbeContent(source);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 
  public static void testProbeContent(Path fichier) throws IOException {
    String type = Files.probeContentType(fichier);
    if (type == null) {
      System.out.println("Impossible de déteminer le type du fichier :"
         + fichier);
    } else {
      System.out.println("le fichier " + fichier + " est du type : " + type);
    }
  }
}