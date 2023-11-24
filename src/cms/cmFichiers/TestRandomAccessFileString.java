package cms.cmFichiers;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class TestRandomAccessFileString {
	
	protected static String path = "c:/tmp/raf.dat";
	
  public static void main(String[] args) {
	  
	  // Création du fichier
	  RandomAccessFile monFichier=null;
	  String message = "Hello Fichier RAF avec un È et un É !";
    try {
      System.out.println("Longueur de la chaine de caractères "+message.length());
      monFichier = new RandomAccessFile(path, "rw");
      monFichier.writeUTF(message);
      monFichier.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try {
        monFichier = new RandomAccessFile(path, "rw");
        System.out.println(monFichier.readUTF());
        monFichier.close();
        }catch(Exception e){
        }

    
    try {
        monFichier = new RandomAccessFile(path, "rw");
        // 5 représente le sixième enregistement puisque le premier commence à 0
        // 4 est la taille des données puisqu'elles sont des entiers de type int 
        // (codé sur 4 octets)
        int tailleEnBytes = monFichier.readUnsignedShort();
        System.out.println("Taille du fichier "+tailleEnBytes);
        byte[] b = new byte[tailleEnBytes];
        monFichier.read(b, 0, tailleEnBytes);
        for(int i=0;i<tailleEnBytes;i++){
        	System.out.println(b[i]);
        }
        String s = new String(b, StandardCharsets.UTF_8);
        System.out.println("Chaine décodée en "+s);
        monFichier.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  
}