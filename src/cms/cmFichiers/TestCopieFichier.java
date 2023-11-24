package cms.cmFichiers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopieFichier {

  public static void main(String args[]) {
    try {
      copierFichier("c:/tmp/source.txt", "c:/tmp/copie.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copierFichier(String source, String destination) throws IOException {
    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      byte buffer[] = new byte[1024];
      int taille = 0;

      fis = new FileInputStream(source);
      fos = new FileOutputStream(destination);
      while ((taille = fis.read(buffer)) != -1) {
        System.out.println(taille);
        fos.write(buffer, 0, taille);
      }
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
        }
      }
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
        }
      }
    }
  }
}