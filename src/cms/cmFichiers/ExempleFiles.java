package cms.cmFichiers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ExempleFiles{

	public static void main(String[] args) throws Exception {
	    Path monFichier = Paths.get("C:/tmp/source.txt");
	    boolean estLisible = Files.isRegularFile(monFichier) &
	                         Files.isReadable(monFichier);
	    System.out.println(monFichier + " est lisible : "+estLisible);
	    
	    //
	    
	    // Ne marche qu'avec Linux
	    /*
	    Path fichier=Paths.get("c:/tmp/test.txt");
	    Set<PosixFilePermission> perms=PosixFilePermissions.fromString("rw-rw-rw-");
	    FileAttribute<Set<PosixFilePermission>>attr=PosixFilePermissions.asFileAttribute(perms);
	    Files.createFile(fichier,attr);
	    */
	    //
	    Path fichier=Paths.get("c:/tmp/test4.txt");
	    fichier.toFile().setWritable(true);
	    Files.delete(fichier);
	    Files.createFile(fichier);
	    fichier.toFile().setWritable(false);
	    System.out.println("Writable : "+Files.isWritable(fichier));

	    
	    monFichier = Paths.get("C:/temp/monfichier.txt");
	   // Path file = Files.createFile(monFichier);
	    
	    // Copie
	    monFichier =
	    Paths.get("C:/tmp/test4.txt");
	    Path monFichierCopie = Paths.get("C:/temp/test4-copie.txt");
	    monFichierCopie.toFile().setWritable(true);
	    Path file = Files.copy(monFichier, monFichierCopie, StandardCopyOption.REPLACE_EXISTING);
	}

}
