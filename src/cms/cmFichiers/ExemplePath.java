package cms.cmFichiers;


import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExemplePath {

	public static void main(String[] args) {
		Path chemin1 = FileSystems.getDefault().getPath("c:/tmp/source.txt");
		//Path chemin2 = new File("c:/tmp/source.txt").toPath();
		Path chemin2 = Paths.get("tmp/source.txt"); // chemin relatif
		System.out.println("toString()     = " + chemin1.toString());
		System.out.println("getFileName()  = " + chemin1.getFileName());
		System.out.println("getRoot()      = " + chemin1.getRoot());
		System.out.println("getName(0)     = " + chemin1.getName(0));
		System.out.println("getNameCount() = " + chemin1.getNameCount());
		System.out.println("getParent()    = " + chemin1.getParent());
		System.out.println("subpath(0,2)   = " + chemin1.subpath(0,2));
		System.out.println("*********");
		System.out.println("toString()     = " + chemin2.toString());
		System.out.println("getFileName()  = " + chemin2.getFileName());
		System.out.println("getRoot()      = " + chemin2.getRoot());
		System.out.println("getName(0)     = " + chemin2.getName(0));
		System.out.println("getNameCount() = " + chemin2.getNameCount());
		System.out.println("getParent()    = " + chemin2.getParent());
		System.out.println("subpath(1,2)   = " + chemin2.subpath(1,2));

		// Iterator sur tous les éléments du chemin
		
	    for (Path name : chemin1) {
	        System.out.println(name);
	    }
	    
	    //
	    Path path = Paths.get("C:/Users/ben/AppData/Local/Temp/./monfichier.txt");
	    System.out.println("normalize()   = " + path.normalize());
	    path = Paths.get("C:/Users/admin/../ben/AppData/Local/Temp/./monfichier.txt");

	    System.out.println("normalize()   = " + path.normalize());
	    
	    
	    
	    
	    Path path1 = Paths.get("C:/tmp/ben");
	    Path path2 = Paths.get("C:/tmp/test");
	    Path path1VersPath2 = path1.relativize(path2);
	    System.out.println(path1VersPath2);
	    Path path2VersPath1 = path2.relativize(path1);
	    System.out.println(path2VersPath1);
	    
	    path1 = Paths.get("C:/");
	    path2 = Paths.get("C:/tmp/ben");
	    path1VersPath2 = path1.relativize(path2);
	    System.out.println(path1VersPath2);
	    path2VersPath1 = path2.relativize(path1);
	    System.out.println(path2VersPath1);
	}

}
