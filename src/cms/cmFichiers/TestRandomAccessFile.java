package cms.cmFichiers;

import java.io.RandomAccessFile;

public class TestRandomAccessFile {
	
	protected static String path = "c:/tmp/raf.dat";
	
  public static void main(String[] args) {
	  
	  // Création du fichier
    try {
      RandomAccessFile monFichier = new RandomAccessFile(path, "rw");
      for (int i = 0; i < 10; i++) {
        monFichier.writeInt(i * 100);
      }
      monFichier.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try {
        RandomAccessFile monFichier = new RandomAccessFile(path, "rw");
        for (int i = 0; i < 10; i++) {
           System.out.println(monFichier.readInt());
        }
        monFichier.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    
    try {
        RandomAccessFile monFichier = new RandomAccessFile(path, "rw");
        // 5 représente le sixième enregistement puisque le premier commence à 0
        // 4 est la taille des données puisqu'elles sont des entiers de type int 
        // (codé sur 4 octets)
        monFichier.seek(5*4);
        System.out.println("Lecture du 6e enregistrement : "+monFichier.readInt());
        monFichier.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  
}