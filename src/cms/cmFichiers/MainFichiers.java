package cms.cmFichiers;

import java.io.*;

public class MainFichiers {
  protected String nomFichier;
  protected File fichier;
  protected static String path = "c:/tmp";
  
  public MainFichiers(String nomFichier) {
    this.nomFichier = nomFichier;
    fichier = new File(nomFichier);
    traitement();
  }

  public static void main(String args[]) {
    new MainFichiers(path);
  }

  private void traitement() {

    if (!fichier.exists()) { 
      System.out.println("le fichier "+nomFichier+"n'existe pas");
      System.exit(1);
      
    }      
     
    System.out.println(" Nom du fichier    : "+fichier.getName());
    System.out.println(" Chemin du fichier : "+fichier.getPath());
    System.out.println(" Chemin absolu     : "+fichier.getAbsolutePath());
    System.out.println(" Droit de lecture  : "+fichier.canRead()); 
    System.out.println(" Droit d'ecriture  : "+fichier.canWrite());
    
    if (fichier.isDirectory() ) {
      System.out.println(" contenu du repertoire ");
      File fichiers[] = fichier.listFiles();
      for(int i = 0; i < fichiers.length; i++) {
  
      	if (fichiers[i].isDirectory()) 
      	  System.out.println("  ["+fichiers[i].getName()+"]");      	
      	else
      	  System.out.println("  "+fichiers[i].getName());
      }
    }     
  }			
}